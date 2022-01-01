package com.presidio.data.reader

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

class CSVReader extends Reader {
  override def readAsDF(spark: SparkSession, path: String): DataFrame = {
    spark.read option ("header", "true") csv path
  }

  override def readAsRDD(spark: SparkSession, path: String): RDD[String] = {
    spark.sparkContext textFile path
  }
}
