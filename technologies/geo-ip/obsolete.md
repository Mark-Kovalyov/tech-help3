## MaxMind (obsolete?)
```
val geoip = spark.read.option("header", true).option("delimiter",",").option("inferSchema",true).csv("/bigdata/db/geo/GeoIPCity.utf-8.csv.bz2")

scala> geoip.printSchema
warning: 1 deprecation (since 2.13.3); for details, enable `:setting -deprecation` or `:replay -deprecation`
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

## Create view for Country selection purpose
```
def geoip2 = geoip.withColumn("start_ip", ipv4_num(col("startIpNum"))).withColumn("end_ip", ipv4_num(col("endIpNum"))).select($"start_ip", $"end_ip", $"startIpNum", $"endIpNum", $"country",$"region",$"city")

geoip2.createOrReplaceTempView("geo_ip_2")
geoip2.persist()
```
