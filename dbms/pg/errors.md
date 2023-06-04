# Errors PG

## database "dht" does not exist

```
$ psql -d dht
psql: error: FATAL:  database "dht" does not exist
DETAIL:  The database subdirectory "pg_tblspc/107489/PG_12_201909212/107490" is missing.
```

```
$ service postgresql status
● postgresql.service - PostgreSQL RDBMS
     Loaded: loaded (/lib/systemd/system/postgresql.service; enabled; vendor preset: enabled)
     Active: active (exited) since Fri 2023-04-28 22:39:41 EEST; 44min ago
   Main PID: 2382 (code=exited, status=0/SUCCESS)
      Tasks: 0 (limit: 19013)
     Memory: 0B
     CGroup: /system.slice/postgresql.service

Apr 28 22:39:41 ryzen-ssd systemd[1]: Starting PostgreSQL RDBMS...
Apr 28 22:39:41 ryzen-ssd systemd[1]: Finished PostgreSQL RDBMS.
```

```
sudo -u postgres bash

postgres=# show data_directory;
       data_directory        
-----------------------------
 /var/lib/postgresql/12/main
(1 row)

```

```
postgres=# \l
                                    List of databases
      Name      |  Owner   | Encoding |   Collate   |    Ctype    |   Access privileges   
----------------+----------+----------+-------------+-------------+-----------------------
 dht            | mayton   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
 musictorrentdb | mayton   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
 postgres       | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
 template0      | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
                |          |          |             |             | postgres=CTc/postgres
 template1      | postgres | UTF8     | en_US.UTF-8 | en_US.UTF-8 | =c/postgres          +
                |          |          |             |             | postgres=CTc/postgres
 torrentdb      | mayton   | UTF8     | en_US.UTF-8 | en_US.UTF-8 |
(6 rows)
```
