# BLOOMFILTER INDEX

```
import spark.implicits._
val uuid = udf(() => java.util.UUID.randomUUID().toString)
val random_1  = spark.range(1, 1000000).toDF.withColumn("uuid",uuid())
random_1.coalesce(1).write.mode("overwrite").option("header", "true").csv("/bigdata/spark/demo-bloom.csv")
```

```
import spark.implicits._

val df = spark.read.option("header", "true").csv("/bigdata/spark/demo-bloom.csv")
val df2 = df.coalesce(1)
df2.write.mode("overwrite").parquet("/bigdata/spark/NoBloomFilter")
df2.write.mode("overwrite")
  .option("parquet.bloom.filter.enabled#uuid", "true")
  .option("parquet.bloom.filter.expected.ndv#uuid", "1000000")
  .parquet("/bigdata/spark/BloomFilter")
```

```
create view demo_bloom_2 as select * from parquet.`/bigdata/spark/BloomFilter`;
explain extended select uuid from demo_bloom_2 where uuid = 'b3adf628-af9f-4da9-81af-b8ddfd5387a5';
```

## With SQL
```text
CREATE BLOOMFILTER INDEX
ON [TABLE] table_name
[FOR COLUMNS( { columnName1 [ options ] } [, ...] ) ]
[ options ]

options
  OPTIONS ( { key1 [ = ] val1 } [, ...] )
```

(Doesn't work with spark-sql CLI?)
```
CREATE BLOOMFILTER INDEX ON geo FOR COLUMNS(city);
```

## With Scala
```scala
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, SaveMode, SparkSession, types}
import org.apache.spark.storage.StorageLevel

val geo : DataFrame = spark.read.parquet("/bigdata/db/geo/GeoIPCity-parquet")

geo.printSchema()
```

```
root
 |-- startIpNum: string (nullable = true)
 |-- endIpNum: string (nullable = true)
 |-- country: string (nullable = true)
 |-- region: string (nullable = true)
 |-- city: string (nullable = true)
 |-- postalCode: string (nullable = true)
 |-- latitude: double (nullable = true)
 |-- longitude: double (nullable = true)
 |-- dmaCode: integer (nullable = true)
 |-- areaCode: integer (nullable = true)
```

in spark-sql:
```
spark-sql --conf "spark.hadoop.hive.cli.print.header=true"
SELECT * FROM parquet.`/bigdata/db/geo/GeoIPCity-parquet` LIMIT 10;
....
select count(1) from (select distinct city from vgeo);
110025
```

## Add bloom index to city:
```
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, SaveMode, SparkSession, types}
import org.apache.spark.storage.StorageLevel

val geo : DataFrame = spark.read.parquet("/bigdata/db/geo/GeoIPCity-parquet")

geo.write.mode("overwrite").option("parquet.bloom.filter.enabled#city", "true").option("parquet.bloom.filter.expected.ndv#city", "110025").parquet("/bigdata/db/geo/GeoIPCity-bloom-parquet")
```
