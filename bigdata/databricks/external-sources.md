# Databricks :: external sources

## extract lines as raw strings from a text file

```
SELECT * FROM text.`dbfs:/FileStore/file-0001.txt`
```

## CSV

This is doesn works
```
select * from csv.`/path/file`
```
and fixed
```
CREATE TABLE tab1 (col1, col2 .....)
USING csv
OPTIONS (
 header = "true"
 delimiter = "|"
)
LOCATION "/path/file"
```
describe
```
describe extended tab1;
```
refresh cached data
```
REFRESH TABLE tab1
```

## JDBC

```
CREATE TABLE name
USING JDBC
OPTIONS (
  url = "jdbc:{type}://{host}:{port},
  dbtable = "{jdbcDatabse}.table",
  user = "{jdbcUsername}",
  password = "{jdbcPassword}"
)
```

## JSON files

```
CREATE TABLE IF NOT EXITST evt_json
 (key BINARY, offset BIGINT, partition INT, 
  timestamp BIGINT, topic STRING, value BINARY)
USING JSON
...

```




