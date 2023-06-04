# Cassandra to Spark

## From

* https://www.youtube.com/watch?v=f5GxvgyHznM

## Sample

```
val dataSet = sqlContext
  .read
  .format("org.apache.spark.sql.cassandra")
  .options(Map("table" -> "logs", "keyspace" -> "mySpace"))
  .load()

dataSet
  .filter("message = 'Log msg'")
  .show()
```
