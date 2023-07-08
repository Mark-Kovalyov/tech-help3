# Radix Tree :

## Comparison of impl:
|Lang|Lib name / package             |Lookup by prefix|Traverse nodes|
|----|-------------------------------|----------------|--------------|
|Java|com.googlecode.concurrent-trees|      +         |              |


## Radix Tree In Postgresql (TODO: Check)

```
postgres=# create table sites(url text);

postgres=# insert into sites values ('postgrespro.ru'),('postgrespro.com'),('postgresql.org'),('planet.postgresql.org');

postgres=# create index on sites using spgist(url);
```
