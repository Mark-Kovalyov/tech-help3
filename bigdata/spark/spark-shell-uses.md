# Spark shell uses

## Run with custom dependency (jar)

```
$ spark-shell --jars 
```

## Import AVRO package

```
$ spark-shell --packages org.apache.spark:spark-avro_2.13:3.4.0
```

---

```
spark-shell> :settings
.....
-classpath = $HOME/.ivy2/jars/org.apache.spark_spark-avro_2.13-3.4.0.jar:....
...
```

### Write AVRO

```
rat.coalesce(1).write.format("avro").save("/aws-ratings/rating-electr2/rating-electr2.avro")
```

## Show env, properties, settings
```
scala> :imports
 1) import java.lang._             (136 types, 143 terms)
 2) import scala._                 (179 types, 168 terms)
 3) import scala.Predef._          (98 terms, 56 are implicit)
 4) import org.apache.spark.SparkContext._ (77 terms, 1 are implicit)
 5) import spark.implicits._       (1 types, 71 terms, 43 are implicit)
 6) import spark.sql               (3 terms)
 7) import org.apache.spark.sql.functions._ (476 terms)
```
