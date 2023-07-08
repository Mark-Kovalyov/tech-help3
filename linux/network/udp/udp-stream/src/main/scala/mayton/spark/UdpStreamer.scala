package mayton.spark

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.{OutputMode, Trigger}
import org.apache.spark.sql.types.StructType

import java.nio.file.Files._
import scala.util.matching.{Regex, UnanchoredRegex}

object UdpStreamer {

  def main(args : Array[String]) : Unit = {

    def ip2numf2(ip:String) : Option[Long] = {
      val ipr = "(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})".r
      ip match {
        case ipr(c1,c2,c3,c4) => Some(0L)
        case _ => None
      }
    }

    def ip2numf(ip: String): Option[Long] = {
      if (ip == "-") return None
      val c: Array[Long] = ip.split("\\.").map(x => x.toLong)
      Some(c(0) << 24 + c(1) << 16 + c(2) << 8 + c(3))
    }


    val spark: SparkSession = SparkSession
      .builder
      .getOrCreate()

    val context = spark.sparkContext
    val conf = spark.conf

    println(s"java  version = ${System.getProperty("java.version")}")
    println(s"scala version = ${util.Properties.versionString}")
    println(s"spark version = ${context.version}")

    context.setLogLevel("INFO")

    conf.set("spark.sql.shuffle.partitions", 3) // For what?

    val schema : StructType = new StructType()
      .add("ts",   "string")
      .add("ip",   "string")
      .add("port", "string")

    val tr : DataFrame = spark
      .readStream
      .schema(schema)
      .option("maxFilesPerTrigger", 1)
      .csv("/bigdata/udp-streamed/input/tr")
      .withColumn("filename", input_file_name())
      .withColumn("file_ts",  current_timestamp())

    val vuze: DataFrame = spark
      .readStream
      .schema(schema)
      .option("maxFilesPerTrigger", 1)
      .csv("/bigdata/udp-streamed/input/vuze")
      .withColumn("filename", input_file_name())
      .withColumn("file_ts", current_timestamp())


    println(s"tr.isStreaming = ${tr.isStreaming}")
    println(s"tr.isStreaming = ${vuze.isStreaming}")

    val aggregation : DataFrame = tr
      .withWatermark("file_ts", "10 minutes")
      .groupBy(window(col("file_ts"), "10 minutes", "5 minutes"), col("ip"))
      .agg(count(col("ip")).alias("count_ips"))

    // Limitations
    // - Data source csv does not support Complete output mode.
    // - Data source csv does not support Update output mode.
    // - Column `window` has a data type of struct<start:timestamp,end:timestamp>, which is not supported by CSV

    //                           Parquet | CSV | Console
    //                           -----------------------
    //   APPEND                   YES
    //   UPDATE
    //   COMPLETE

    aggregation
      .writeStream
        .queryName("Count uniqie IPS")
        .outputMode(OutputMode.Append()) // APPEND | COMPLETE | UPDATE
        .format("parquet") // console | csv | parquet
        .option("path", "/bigdata/udp-streamed/report/parquet")
        .option("truncate", false)
        .option("checkpointLocation", "/bigdata/udp-streamed/checkpoint")
        .trigger(Trigger.ProcessingTime("15 seconds"))
      .start()
      .awaitTermination()

    spark.stop()

  }

}
