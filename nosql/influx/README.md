# InfluxDb

* https://www.influxdata.com/

## Drop bucket
```
influx bucket delete -n radio -o mayton
Error: failed to find bucket "radio": Get "http://localhost:8086/api/v2/buckets?name=radio&org=mayton": dial tcp 127.0.0.1:8086: connect: connection refused

(find internal IP of InfluxDb in docker)
docker network inspect
....
 "Containers": {
            "0b7e19bfd9aa37c7cf555793027dd2d4e0ecbefb047243a80e62b4b1104da512": {
                "Name": "focused_joliot",
                "EndpointID": "458f0fde787cd3a4265690d464eeb4706719305928a9291827bc2de4ac8c752b",
                "MacAddress": "02:42:ac:12:00:02",
                "IPv4Address": "172.18.0.2/16",
......

(drop)
# influx bucket delete --name radio --org mayton --host http://172.18.0.2:8086 --token ****************************
ID                      Name    Retention       Shard group duration    Organization ID         Schema Type     Deleted
25661cc59c43611f        radio   168h0m0s        24h0m0s                 c2056d410c9236f9        implicit        true
```

## Create bucket with retention
```                                                                                   
influx bucket create --name infotek-bucket --org infotek --retention 14d --host http://172.18.0.2:8086 --token *********************
```

## Create organization
```
influx org create ...
```

## Delete data from bucket
```
influx delete --bucket example-bucket --start '1970-01-01T00:00:00Z' --stop '2025-01-01T00:00:00Z' --host http://172.18.0.2:8086 --token ****************
```


## Schema

Good Tags schema - Data encoded in multiple tags
-------------
weather_sensor,crop=blueberries,plot=1,region=north temp=50.1 1472515200000000000
weather_sensor,crop=blueberries,plot=2,region=midwest temp=49.8 1472515200000000000


## Influx/Scala

```
libraryDependencies += "com.influxdb" % "influxdb-client-scala" % "6.3.0"
```

```scala
package example

import akka.actor.ActorSystem
import akka.stream.scaladsl.{Keep, Sink, Source}
import com.influxdb.annotations.{Column, Measurement}
import com.influxdb.client.domain.WritePrecision
import com.influxdb.client.scala.InfluxDBClientScalaFactory
import com.influxdb.query.FluxRecord
import com.influxdb.client.write.Point

import java.time.Instant
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object InfluxDB2ScalaExample {

  implicit val system: ActorSystem = ActorSystem("examples")

  def main(args: Array[String]): Unit = {

    // You can generate an API token from the "API Tokens Tab" in the UI
    val token  = sys.env.get("INFLUX_TOKEN")
    val org    = "mayton"
    val bucket = "radio"

    val client = InfluxDBClientScalaFactory.create("http://localhost:8086", token.get.toCharArray, org, bucket)
  }
}
```


```scala
val record = "mem,host=host1 used_percent=23.43234543"

val source = Source.single(record)
val sink = client.getWriteScalaApi.writeRecord()
val materialized = source.toMat(sink)(Keep.right)

Await.result(materialized.run(), Duration.Inf)

```


```
val point = Point
  .measurement("mem")
  .addTag("host", "host1")
  .addField("used_percent", 23.43234543)
  .time(Instant.now(), WritePrecision.NS)

val source = Source.single(point)
val sink = client.getWriteScalaApi.writePoint()
val materialized = source.toMat(sink)(Keep.right)

Await.result(materialized.run(), Duration.Inf)

```

```
val mem = new Mem()
mem.host = "host1"
mem.used_percent = 23.43234543
mem.time = Instant.now

val source = Source.single(mem)
val sink = client.getWriteScalaApi.writeMeasurement()
val materialized = source.toMat(sink)(Keep.right)
Await.result(materialized.run(), Duration.Inf)



@Measurement(name = "mem")
class Mem() {
  @Column(tag = true)
  var host: String = _
  @Column
  var used_percent: Double = _
  @Column(timestamp = true)
  var time: Instant = _
}

```

Execute Flux query
```
val query = """from(bucket: "radio")
    |> range(start: -1d)
"""

// Result is returned as a stream
val results = client.getQueryScalaApi().query(query)

val sink = results
  // print results
  .runWith(Sink.foreach[FluxRecord](it => println(s"$it")
  ))

// wait to finish
Await.result(sink, Duration.Inf)

```

```
client.close()
system.terminate()

```