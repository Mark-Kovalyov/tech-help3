# Partitioning

## Links

* https://postgrespro.ru/docs/postgresql/12/ddl-partitioning
* https://www.postgresql.org/docs/12/ddl-partitioning.html

## Range Partitioning

```
CREATE TABLE measurement (
    city_id         int not null,
    logdate         date not null,
    peaktemp        int,
    unitsales       int
) PARTITION BY RANGE (logdate);

CREATE TABLE measurement_y2006m02 PARTITION OF measurement
    FOR VALUES FROM ('2006-02-01') TO ('2006-03-01');

CREATE TABLE measurement_y2007m12 PARTITION OF measurement
    FOR VALUES FROM ('2007-12-01') TO ('2008-01-01')
    TABLESPACE fasttablespace;

CREATE INDEX ON measurement (logdate);
```

## List Partitioning

```
create table sales (
    id         serial        ,
    product_id integer       NOT NULL,
    quantity   integer       CHECK (quantity > 0),
    price      numeric(38,2) CHECK (price > 0),
    region     VARCHAR(5)    CHECK (region in ('east','north','west','south'))
)
PARTITION BY LIST (region);

CREATE TABLE part_a PARTITION OF sales FOR VALUES IN ('east','north');
CREATE TABLE part_b PARTITION OF sales FOR VALUES IN ('west','south');
```

```
create table torrents2(
id            integer,
category      integer,
status        text,
name          text,   
numFiles      integer,
size          bigint,
seeders       integer ,
leechers      integer ,
username      text    ,
added         integer ,
description   text    ,
imdb          text    ,
language      text    ,
textLanguage  text    ,
infoHash      text    
) PARTITION BY RANGE (category);
```

### Errors:
```
ERROR:  unique constraint on partitioned table must include all partitioning columns
DETAIL:  PRIMARY KEY constraint on table "torrents2" lacks column "category" which is part of the partition key.
```

## Hash Partitioning

(since Postgresql 11.x)
```
CREATE TABLE hp ( foo text ) PARTITION BY HASH (foo);
CREATE TABLE hp_0 PARTITION OF hp FOR VALUES WITH (MODULUS 3, REMAINDER 0) TABLESPACE space_01;
CREATE TABLE hp_1 PARTITION OF hp FOR VALUES WITH (MODULUS 3, REMAINDER 1) TABLESPACE space_02;
CREATE TABLE hp_2 PARTITION OF hp FOR VALUES WITH (MODULUS 3, REMAINDER 2) TABLESPACE space_03;
```

```
create table torrents2(
id            integer,
category      integer,
status        text,
name          text,   
numFiles      integer,
size          bigint,
seeders       integer ,
leechers      integer ,
username      text    ,
added         integer ,
description   text    ,
imdb          text    ,
language      text    ,
textLanguage  text    ,
infoHash      text    
) PARTITION BY RANGE (category);

CREATE TABLE torrents2_1 PARTITION OF torrents2 FOR VALUES FROM (100) TO (200);
CREATE TABLE torrents2_2 PARTITION OF torrents2 FOR VALUES FROM (200) TO (300);
CREATE TABLE torrents2_3 PARTITION OF torrents2 FOR VALUES FROM (300) TO (400);
CREATE TABLE torrents2_4 PARTITION OF torrents2 FOR VALUES FROM (400) TO (500);
CREATE TABLE torrents2_5 PARTITION OF torrents2 FOR VALUES FROM (500) TO (600);
CREATE TABLE torrents2_6 PARTITION OF torrents2 FOR VALUES FROM (600) TO (700);

insert into torrents2 (select * from torrents);

CREATE INDEX torrents2_gist_trgm_idx ON torrents2 USING GIN(name gin_trgm_ops);
```


## Show tablespace with location

```
select spcname,pg_tablespace_location(oid) from pg_tablespace;
```
