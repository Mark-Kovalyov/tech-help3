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
 --conf "spark.inputcsv=/bigdata/udp-streamed/input/tr" \
 --conf "spark.format=parquet" \
 --conf "spark.checkpointlocation=/bigdata/udp-streamed/checkpoint-appender/tr" \
 --conf "spark.sql.parquet.compression.codec=uncompressed" \
  target/scala-2.13/udp-stream_2.13-1.0.jar

