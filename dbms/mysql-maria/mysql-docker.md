docker run --name mariadbtest -e MYSQL_ROOT_PASSWORD=**** -p 3306:3306 -d docker.io/library/mariadb
docker exec -it mariadbtest bash
mysql -h localhost -u root -p

MariaDB [mydb]> create table test(n text);
Query OK, 0 rows affected (0.008 sec)

MariaDB [mydb]> insert into test values('Hello');
Query OK, 1 row affected (0.002 sec)

MariaDB [mydb]> insert into test values('привет');
Query OK, 1 row affected (0.012 sec)

MariaDB [mydb]> select * from test;
+--------------+
| n            |
+--------------+
| Hello        |
| привет       |
+--------------+
2 rows in set (0.000 sec)

MariaDB [mydb]> SELECT * FROM test WHERE n REGEXP '[а-я]';
+--------------+
| n            |
+--------------+
| привет       |
+--------------+
1 row in set (0.000 sec)

MariaDB [mydb]> SELECT * FROM test WHERE n REGEXP concat('[',(_utf16 0x430),'-',(_utf16 0x44f),']');
+--------------+
| n            |
+--------------+
| привет       |
+--------------+
1 row in set (0.000 sec)
