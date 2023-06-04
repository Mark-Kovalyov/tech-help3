# Neo4j

## Install


https://neo4j.com/download-center/#community
https://dist.neo4j.org/cypher-shell/cypher-shell-5.2.0.zip

## Maven

```
<dependency>
  <groupId>org.neo4j.driver</groupId>
  <artifactId>neo4j-java-driver</artifactId>
  <version>5.3.0</version>
</dependency>
```

* The Neo4j Java Driver Manual v4.4 https://neo4j.com/docs/java-manual/4.4/

## Languages and APIs

* Gremlin
* REST
* Neo4j Browser http://localhost:7474

## Run from docker

```
docker run --name sparsmat01 -p7474:7474 -p7687:7687 --env NEO4J_AUTH=mayton/pwd123 neo4j:latest -v /bigdata/neo4j/data:/data -v /bigdata/neo4j/import:/var/lib/neo4j/import
```

```
docker run \
    --name testneo4j \
    -p7474:7474 -p7687:7687 \
    -d \
    -v /bigdata/neo4j/data:/data \
    -v /bigdata/neo4j/logs:/logs \
    -v /bigdata/neo4j/import:/var/lib/neo4j/import \
    -v /bigdata/neo4j/plugins:/plugins \
    --env NEO4J_AUTH=neo4j/pwd123 \
    neo4j:latest
```
drop container
```
docker ps -a
docker rm 450698374956734
```

## Importing CSV Data into Neo4j

* LOAD CSV (Cypher command: this command is a great starting point and handles small- to medium-sized data sets (up to 10 million records).)
* neo4j-admin bulk import tool:
* Kettle import tool: maps and executes steps for the data process flow and works well for very large data sets, especially if developers are already familiar with using this tool.

### LOAD CSV

```
LOAD CSV FROM 'file:///bigdata/db/geo/GeoIPCity.utf-8.csv'
LOAD CSV FROM 'https://data.neo4j.com/northwind/customers.csv'
```

## Sample for Groovy DSL

```groovy
v_emp_7369 = g1.addVertex(`[empno = 7369, ename = SMITH]`)

v_job_CLERK = g1.addVertex(`[job = CLERK]`)

v_dept_10 = g1.addVertex(`[deptno = 10, loc = NEW YORK, dname = ACCOUNTING]`)

e0 = g1.addEdge(v_emp_7369, v_job_CLERK, `has_job`)
e1 = g1.addEdge(v_emp_7369, v_dept_10, `work_in_dept`)

```

## set

http://download.freebase.com/datadumps/latest/browse/film/performance.tsv
