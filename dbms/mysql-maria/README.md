# MySQL

* https://mariadb.com/

## Install
```
apt install mariadb-server
```

## Network ports

|Port|Desc|
|-|-|
|3306||

## Check status
```
$ sudo systemctl status mysql.service
[sudo] password for $USER:
● mariadb.service - MariaDB 10.3.34 database server
     Loaded: loaded (/lib/systemd/system/mariadb.service; enabled; vendor preset: enabled)
```


## Login as root
```
$ sudo mysql -u root
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 39
Server version: 10.3.34-MariaDB-0ubuntu0.20.04.1 Ubuntu 20.04

Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]>

```

## Create user

```
SELECT name FROM mysql.user;

CREATE USER mtn@'localhost' IDENTIFIED BY '*****';
```

## Login as user with Password identification
```
mysql -u mtn -p
```

## Create tablespace

* MariaDb doesnt support tablespaces?

## Where is datasegment stored?
```
MariaDB [(none)]> select @@datadir;
+-----------------+
| @@datadir       |
+-----------------+
| /var/lib/mysql/ |
+-----------------+
1 row in set (0.000 sec)
```

Move to another place
```
sudo mkdir /bigdata/mariadb
chown -R mysql:mysql /bigdata/mariadb
rsync -av /var/lib/mysql /bigdata/mariadb
```
Configure server
```
datadir                 = /bigdata/mariadb/mysql
```
Configure client
```

```


## Create database DHT and grant privs
```
CREATE DATABASE dht;
GRANT ALL PRIVILEGES ON dht.* TO 'mtn'@'localhost';
```

## Remove all software

```
systemctl stop mysql
apt-get remove --purge mysql-server mysql-client mysql-common
```

## Execute SQL script
```
mysql> source file.sql
```

## Execute SQL from pipeline (check)
```
mkfifo /tmp/mysqltsv
cat file.csv | sed -e 's/,/\t/g' > /tmp/mysqltsv
mysql -e "load data infile '/tmp/mysqltsv' into table tblname"
```

## Export to csv


```
SELECT id,name,uploader,category_id,size,hash,created_at,torrent_status,seeders,leechers,tags FROM torrents
INTO OUTFILE '/backup/out1.csv'
FIELDS ENCLOSED BY '"'
TERMINATED BY ';'
ESCAPED BY '"'
LINES TERMINATED BY '\n';
```

```
mysql torrents --verbose -u mayton --password=********  < script.sql | tr '\t' '\037' | tail -n +6 > /backup/out1.csv
```

## Migrate to Postgres

```
CREATE TABLESPACE music_torrent_space OWNER mayton LOCATION '/bigdata/pg/music_torrent_space';

CREATE DATABASE musictorrentdb OWNER mayton TABLESPACE music_torrent_space;

CREATE TABLE torrents(
 bigint int primary key,
 name text,
 uploader text,
 category_id bigint,
 size bigint,
 hash varchar(40),
 created_at timestamp without time zone,
 torrent_status int,
 visible_status int,
 downloads_count int,
 seeders int,
 leechers int,
 tags text
) tablespace music_torrent_space;

```

transfer with pipeline

script.sql
```

```

```
mysql torrents --verbose -u mayton --password=*********  < script.sql | \
  tr '\t' '\037' | \
  tail -n +6 > /backup/out1.csv
```

script2.sql
```
\COPY torrents FROM /backup/out1.csv
```

```
psql -d musictorrentdb -a -f script2.sql
```

```
sed -i '/ENGINE=InnoDB/ s//ENGINE=MyISAM/g' /backup/out1.csv
```

## Calculate segment Size

```
SELECT
  TABLE_NAME AS `Table`,
  ROUND((DATA_LENGTH + INDEX_LENGTH) / 1024 / 1024) AS `Size (MB)`
FROM
  information_schema.TABLES
WHERE
  TABLE_SCHEMA = "zap"
ORDER BY
  (DATA_LENGTH + INDEX_LENGTH)
DESC;

```

## Describe index
```
SHOW INDEX FROM <tab>;
```

## Primary
```
SHOW KEYS FROM <tab> WHERE Key_name = 'PRIMARY'
```
## Show ALL
```
show table status;
```

## Fastest way to DROP INDEX (MyISAM)

* No way?

SELECT
    *
FROM
    article_cross
WHERE
    1=1
INTO OUTFILE '/backup/maria-out/article-cross.csv'
FIELDS ENCLOSED BY '"'
TERMINATED BY ';'
ESCAPED BY '"'
LINES TERMINATED BY '\r\n';
