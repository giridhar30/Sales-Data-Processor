package com.presidio.data.util

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

/*
 * concrete implementation of Reader that
 * reads input data from CSV file
 */
class CSVReader extends Reader {

  // reads csv as DataFrame(DF)
  override def readAsDF(spark: SparkSession, path: String): DataFrame =
    spark.read option ("header", "true") csv path

  // reads csv as Resilient Distributed Data(RDD)
  override def readAsRDD(spark: SparkSession, path: String): RDD[String] =
    spark.sparkContext textFile path
}
