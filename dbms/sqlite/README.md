# SQLITE

## FTS5 or ASCII
```SQL
CREATE TABLE IF NOT EXISTS "torrents" (
  "id" integer PRIMARY KEY NOT NULL,
  "category" integer NOT NULL,
  "status" text NOT NULL,
  "name" text NOT NULL,
  "numFiles" integer NOT NULL,
  "size" float NOT NULL,
  "seeders" integer NOT NULL,
  "leechers" integer NOT NULL,
  "username" text NOT NULL,
  "added" integer NOT NULL,
  "description" text,
  "imdb" text,
  "language" text,
  "textLanguage" text,
  "infoHash" text NOT NULL
);
```

```SQL
CREATE VIRTUAL TABLE torrents_v USING FTS5(
  id UNINDEXED,
  category UNINDEXED,
  size UNINDEXED,
  name,tokenize="ascii separators '.-_ '");

INSERT INTO TORRENTS_V VALUES SELECT id,category,size,name from torrents;
```

```
select name,'magnet:?xt=urn:btih:' || infoHash || '&dn=' || replace(name,' ','_') from torrents where name like '%book%' limit 100;

select id,name from torrents_v where name MATCH '"backup and database"' limit 100;

select name,'magnet:?xt=urn:btih:' || infoHash || '&dn=' || replace(name,' ','_') from torrents where id = 5108599

```
