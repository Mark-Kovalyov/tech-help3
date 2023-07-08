import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}
import org.apache.spark.ml.{Pipeline, PipelineModel}
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, StringIndexerModel, VectorIndexer, VectorIndexerModel}

import spark.implicits._

val home = "/mnt/c/db/ip2loc"

val ip2loc : DataFrame = spark.read.format("orc").load(home + "/ip2loc_orc")

val udp_all = spark.read.format("orc").load(home + "/udp_snap_2023-07-04_orc")
