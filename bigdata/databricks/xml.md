# Databricks XML


```
<!-- https://mvnrepository.com/artifact/com.databricks/spark-xml -->
<dependency>
    <groupId>com.databricks</groupId>
    <artifactId>spark-xml_2.13</artifactId>
    <version>0.16.0</version>
</dependency>

```

```
spark-shell -cp ~/.m2/repository/
```

```scala
val df = spark.read
      .format("com.databricks.spark.xml")
      .option("rowTag", "changeset")
      .xml("/bigdata/torrent/incoming/changesets-230403.osm.bz2")
```
