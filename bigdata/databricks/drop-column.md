# Drop column

```
9.1 LTS (includes Apache Spark 3.1.2, Scala 2.12)

spark.sql.hive.metastore.version 1.2.1
spark.databricks.cluster.profile singleNode
spark.master local[*, 4]
spark.sql.hive.metastore.jars maven
spark.databricks.delta.preview.enabled true
```

## Delta table

```
create table analytics.emp_delta(
  empno integer,
  ename string,
  job string,
  mgr integer,
  hiredate date,
  sal decimal,
  comm decimal,
  depno integer) using delta;
```

```
%sql

alter table analytics.emp_delta drop column mgr;

java.lang.UnsupportedOperationException: Unrecognized column change
class org.apache.spark.sql.connector.catalog.TableChange$DeleteColumn.
You may be running an out of date Delta Lake version.
```

```
desc detail analytics.emp_delta;
....
minReaderVersion: 1
minWriterVersion: 2
```

## Parquet table

```
create table analytics.emp_parquet(
  .....
) using parquet;  
```

```
alter table analytics.emp_parquet drop column mgr;

>> DROP COLUMN is only supported with v2 tables.
```

## Orc table
```
create table analytics.emp_orc(
  .....
) using orc;  
```

```
alter table analytics.emp_orc drop column mgr;

>> DROP COLUMN is only supported with v2 tables.
```
