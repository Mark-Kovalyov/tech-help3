#!/bin/bash -v

set -e

sbt "clean; package"

spark-submit \
 --verbose \
 --master local[2] \
 --name "udp-stream" \
 --driver-memory 2G \
 --executor-memory 2G \
 --deploy-mode client \
 --packages org.apache.spark:spark-sql-kafka-0-10_2.12:3.4.1 \
 --class "mayton.spark.UdpStreamerAppender" \
 --conf "spark.inputcsv=/bigdata/udp-streamed/input/vuze" \
 --conf "spark.format=csv" \
 --conf "spark.checkpointlocation=/bigdata/udp-streamed/checkpoint-appender/vuze" \
  target/scala-2.13/udp-stream_2.13-1.0.jar

