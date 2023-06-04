# Binary Data in spark 

```
scala>   val bytes = Array[Byte](1,2,3)
val bytes: Array[Byte] = Array(1, 2, 3)

scala>

scala>   val df = spark.range(2).withColumn("blob", lit(bytes))
val df: org.apache.spark.sql.DataFrame = [id: bigint, blob: binary]

scala> df.show()
+---+----------+
| id|      blob|
+---+----------+
|  0|[01 02 03]|
|  1|[01 02 03]|
+---+----------+
```