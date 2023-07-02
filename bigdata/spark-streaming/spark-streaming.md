# Spark Streaming

* data generated continually
* business requires like rolling min-max computations

## Chalenges (for map-reduce)

* iterative execution
* batched behaviour
* continuous running

## Challenges of stream processing

## The reasons for the Stream Establishment


## Stream from file

```
val logSchema = 

val df = spark.readStream
   .schema()
      .csv("/bigdata/udp-streamed/transmission")

```
