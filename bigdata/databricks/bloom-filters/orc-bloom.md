# Apache ORC bloom filters

```sql
DROP TABLE geo_bloom;
CREATE TABLE geo_bloom(
  startIpNum string,
  endIpNum string,
  country string,
  region string,
  city string,
  postalCode string,
  latitude double,
  longitude double,
  dmaCode int,
  areaCode int
)
USING ORC
OPTIONS (
  orc.bloom.filter.columns 'city',
  orc.dictionary.key.threshold '1.0',
  orc.column.encoding.direct 'name'
);
```

```scala
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, Encoders, SaveMode, SparkSession, types}
import org.apache.spark.storage.StorageLevel

val geo : DataFrame = spark.read.parquet("/bigdata/db/geo/GeoIPCity-parquet")

val sortedGeo : DataFrame = geo.sort("country", "city").coalesce(1)

spark.time(sortedGeo.persist(StorageLevel.DISK_ONLY))

spark.time(sortedGeo
  .write.mode("overwrite")
  .option("orc.bloom.filter.columns", "city")
  .option("orc.dictionary.key.threshold", "1.0")
  .option("orc.column.encoding.direct", "name")
  .orc("/bigdata/db/geo/GeoIPCity-bloom-sorted-orc"))
```
