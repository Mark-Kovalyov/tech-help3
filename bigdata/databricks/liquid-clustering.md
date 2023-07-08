# Liquid clustering (Since Databricks Runtime 13.2)

* Delta Lake liquid clustering replaces table partitioning and ZORDER to
  simplify data layout decisions and optimize query performance. Liquid
  clustering provides flexibility to redefine clustering keys without
  rewriting existing data, allowing data layout to evolve alongside analytic
  needs over time.
* You can specify up to 4 columns as clustering keys.
* Structured Streaming workloads do not support clustering-on-write.

## Creat
```
CREATE TABLE table1(col0 int, col1 string) USING DELTA CLUSTER BY (col0);
```
## Change
```
ALTER TABLE table_name CLUSTER BY (new_column1, new_column2);
```
## Turn off
```
ALTER TABLE table_name CLUSTER BY NONE;
```
