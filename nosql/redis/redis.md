# Redis

## Ports

|Port|Desc|
|----|----|
|6379|TCP |


## Connect to redis with TLS socket protocol

```
$ redis-cli --tls -h host005.cache.azure.net -p 55555 -a "*******************"
```

## Start server with Docker

```
docker network create redis-net
docker run -p 6379:6379 --network redis-net -d redis 
```

## Start client with Docker
```

```

## Select all keys
```
127.0.0.1:6379> keys *
 1) "emp:7839"
 2) "emp:7844"
 3) "emp:7876"
 4) "emp:7782"
 5) "emp:7900"
 6) "emp:7654"
 7) "emp:7369"
 8) "emp:7934"
 9) "foo"
10) "emp:7521"
11) "x"
12) "emp:7698"
13) "emp:7902"
14) "emp:7499"
15) "emp:7788"
16) "emp:7566"
```

## Load hashmap keys

```
HMSET emp:7369 ename "SMITH" job "CLERK" mgr "7902" hiredate "1980-12-17T00:00:00Z" sal 800 deptno 20
HMSET emp:7499 ename "ALLEN" job "SALESMAN" mgr "7698" hiredate "1981-02-20T00:00:00Z" sal 1600 comm "300" deptno 30
```

```
127.0.0.1:6379> HKEYS emp:7369
1) "ename"
2) "job"
3) "mgr"
4) "hiredate"
5) "sal"
6) "deptno"
127.0.0.1:6379> HVALS emp:7369
1) "SMITH"
2) "CLERK"
3) "7902"
4) "1980-12-17T00:00:00Z"
5) "800"
6) "20"
127.0.0.1:6379> HGET emp:7369 ename
"SMITH"
```
