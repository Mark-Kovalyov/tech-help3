# GeoIp

Country|Blocks |IPs(v4)   |
-------|-------|----------|
USA    |834669 |1525819539|
RU     | 67718 |  45330554|
UA     | 19178 |  10637078|
BY     |  1185 |   1870943|
KZ     |  6866 |   3361838|

## Ip2Location

```
val IP2LOC_HOME = "/bigdata/db/ip2location"

val ip2loc = spark.read.option("header", false).option("delimiter",",").option("inferSchema",true).csv(IP2LOC_HOME + "/ip2location-lite-db3.csv.bz2").withColumnRenamed("_c0","ip_from").withColumnRenamed("_c1","ip_to").withColumnRenamed("_c2","country_code").withColumnRenamed("_c3","country_name").withColumnRenamed("_c4","region_name").withColumnRenamed("_c4","city_name")

ip2loc.persist()

ip2loc.createOrReplaceTempView("ip_to_loc")
```

```
root
 |-- ip_from: long (nullable = true)
 |-- ip_to: long (nullable = true)
 |-- country_code: string (nullable = true)
 |-- country_name: string (nullable = true)
 |-- region_name: string (nullable = true)
 |-- _c5: string (nullable = true)

```

## IP address to Long
```
def powLong(x:Int,y:Int) : Long = {
  (1 to y).map(_ => x).foldLeft(1L)((z1,z2) => z1.toLong * z2.toLong)
}

def Num(ipv4:String) : Long = {
  ipv4
  .split("\\.")
  .map(_.toInt)
  .toList
  .reverse
  .zipWithIndex
  .map(x => (powLong(256, x._2), x._1))
  .map {case (x,y) => x * y }
  .sum
}
```

```
import spark.implicits._

val ipv4_num = udf((ip:String) => ipv4toNum(ip))

spark.udf.register("ipv4_num", ipv4_num)
```


## Join

```
val udplog = spark.read.option("header", false).option("delimiter",";").option("inferSchema",true).csv("/bigdata/udp/v2/*.bz2").withColumnRenamed("_c0", "timestamp").withColumnRenamed("_c1", "ip").withColumnRenamed("_c2", "port")

udplog.createOrReplaceTempView("udplog")
udplog.persist()

root
 |-- timestamp: timestamp (nullable = true)
 |-- ip: string (nullable = true)
 |-- port: integer (nullable = true)


val udplog_unq = udplog.select("ip").filter("ip LIKE '%.%.%.%'").distinct().withColumn("ip_num", ipv4_num(col("ip")))

udplog_unq.createOrReplaceTempView("udplog_unq")
```

```
val bycountry = spark.sql("""
   SELECT *
   FROM
     ip_to_loc i INNER JOIN udplog_unq u
            ON  i.ip_from <= u.ip_num
             AND u.ip_num <= i.ip_to
""".stripMargin)

bycountry.show()

bycountry.createOrReplaceTempView("report")
```

```
scala> spark.sql("select count(*),country_code from report group by country_code order by 1 desc limit 10").show(1000)
+--------+------------+                                                         
|count(1)|country_code|
+--------+------------+
|    1993|          RU|
|     290|          UA|
|     161|          US|
|      98|          GB|
|      81|          PL|
|      79|          BY|
|      76|          IN|
|      75|          NL|
|      74|          KZ|
|      71|          BR|
+--------+------------+
```

## Export to compressed set

```
bycountry
 .coalesce(1)
 .write
 .mode("overwrite")
 .partitionBy("country_code")
 .option("orc.compress", "snappy")
 .option("orc.bloom.filter.columns", "ip_num")
 .orc("/bigdata/udp/orc/udp-51413")


```
