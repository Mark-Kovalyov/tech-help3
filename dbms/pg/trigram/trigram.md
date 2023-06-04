# PostgreSQL and trigram search

* Link https://www.postgresql.org/docs/current/pgtrgm.html

## Data tables

```sql
=> \d+ torrents;
                                         Table "public.torrents"
    Column    |       Type       | Collation | Nullable | Default | Storage  | Stats target | Description
--------------+------------------+-----------+----------+---------+----------+--------------+-------------
 id           | integer          |           | not null |         | plain    |              |
 category     | integer          |           | not null |         | plain    |              |
 status       | text             |           | not null |         | extended |              |
 name         | text             |           | not null |         | extended |              |
 numFiles     | integer          |           | not null |         | plain    |              |
 size         | double precision |           | not null |         | plain    |              |
 seeders      | integer          |           | not null |         | plain    |              |
 leechers     | integer          |           | not null |         | plain    |              |
 username     | text             |           | not null |         | extended |              |
 added        | integer          |           | not null |         | plain    |              |
 description  | text             |           |          |         | extended |              |
 imdb         | text             |           |          |         | extended |              |
 language     | text             |           |          |         | extended |              |
 textLanguage | text             |           |          |         | extended |              |
 infoHash     | text             |           | not null |         | extended |              |
Indexes:
    "torrents_pkey" PRIMARY KEY, btree (id)
    "torrents_pk" btree (id)
Access method: heap

=> \d+ categories;
                                 Table "public.categories"
 Column |  Type   | Collation | Nullable | Default | Storage  | Stats target | Description
--------+---------+-----------+----------+---------+----------+--------------+-------------
 id     | integer |           | not null |         | plain    |              |
 name   | text    |           |          |         | extended |              |
Indexes:
    "categories_pkey" PRIMARY KEY, btree (id)
Access method: heap
```

```
drop view vtorrents;
create view vtorrents(
  id,
  category,
  category_id,
  name,
  size,
  hash,
  magnet
) as
select
  torrents2.id,
  categories.name,
  torrents2.category,
  torrents2.name,
  size,
  torrents2.infohash,
  'magnet:?xt=urn:btih:' || infohash || '&dn=' || torrents2.name || '&xl=' || size
from torrents2 inner join categories on (torrents2.category = categories.id);
```




## Add support for pg_trgm module

### Check for existing modules (PostgreSQL 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1))
```
postgres=# \dx
                                    List of installed extensions
  Name   | Version |   Schema   |                            Description                            
---------+---------+------------+-------------------------------------------------------------------
 cube    | 1.4     | public     | data type for multidimensional cubes
 pg_trgm | 1.4     | public     | text similarity measurement and index searching based on trigrams
 plpgsql | 1.0     | pg_catalog | PL/pgSQL procedural language
(3 rows)

postgres=# select * from pg_extension;
  oid   | extname | extowner | extnamespace | extrelocatable | extversion | extconfig | extcondition
--------+---------+----------+--------------+----------------+------------+-----------+--------------
  13453 | plpgsql |       10 |           11 | f              | 1.0        |           |
 107506 | pg_trgm |       10 |         2200 | t              | 1.4        |           |
 108287 | cube    |       10 |         2200 | t              | 1.4        |           |
(3 rows)
```

under superuser in custom db
```
# CREATE EXTENSION "pg_trgm";
CREATE EXTENSION
```

## Create trigram index

```
\timing on
# CREATE INDEX torrents_gist_trgm_idx ON torrents USING GIST (name gist_trgm_ops);
CREATE INDEX torrents_gin_trgm_idx ON torrents USING GIN (name gin_trgm_ops);
```

## Select with '%' operator

* Based on pg_trgm.similarity_threshold
* Function  similarity

```
select v.*  from vtorrents v where category like 'Other%' and name % 'orelly' limit 2000;
```

```
=> select strict_word_similarity('Hoola', 'Hoola holla girls like hooligans');
 strict_word_similarity
------------------------
                      1
(1 row)

=> select similarity('Hoola', 'Hoola holla girls like hooligans');
 similarity
------------
 0.23076923
(1 row)
```
trigrams:
```
> select show_trgm('hoola hoola girls like hooligans');

{"  g","  h","  l"," gi"," ho"," li",ans,gan,gir,hoo,iga,ike,irl,"ke ","la ",lig,lik,"ls ","ns ",ola,oli,ool,rls}
(1 row)
```
