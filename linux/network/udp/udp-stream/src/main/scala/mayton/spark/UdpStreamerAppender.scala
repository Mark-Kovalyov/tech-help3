package mayton.spark

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.{OutputMode, Trigger}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType, TimestampType}

object UdpStreamerAppender {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession
      .builder
      .getOrCreate()

    val context = spark.sparkContext
    val conf = spark.conf

    println(s"java  version = ${System.getProperty("java.version")}")
    println(s"scala version = ${util.Properties.versionString}")
    println(s"spark version = ${context.version}")

    context.setLogLevel("INFO")

    val inputcsv           = conf.get("spark.inputcsv")
    val format             = conf.get("spark.format")
    val checkpointLocation = conf.get("spark.checkpointlocation")
    val path               = conf.get("spark.path")

    conf.set("spark.sql.shuffle.partitions", 3) // For what?

    val schema = StructType(Array(
      StructField("ts",   TimestampType,  true),
      StructField("ip",   StringType,     true),
      StructField("port", IntegerType,    true)
    ))

    /*val structureSchema = new StructType()
      .add("name", new StructType()
      .add("id", StringType)
      .add("salary", IntegerType)*/

    spark
      .readStream
      .schema(schema)
        .option("maxFilesPerTrigger", 5)
        .option("delimiter", ";")
        .csv(inputcsv)
      .writeStream
        .queryName("Append ...")
        .outputMode("append")  // OutputMode.Append()) // APPEND | COMPLETE | UPDATE
        .format(format)        // "parquet" | console | csv | parquet
        .option("path", path)
        .option("truncate", false)
        .option("checkpointLocation", checkpointLocation) //"")
        .trigger(Trigger.ProcessingTime("190 seconds"))
        .start()
        .awaitTermination()

    spark.stop()


  }

}
