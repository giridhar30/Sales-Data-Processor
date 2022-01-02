package com.presidio.data.util

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

// trait for reading input data
trait Reader {

  // read data as DF
  def readAsDF(spark: SparkSession, path: String): DataFrame

  // read data as RDD
  def readAsRDD(spark: SparkSession, path: String): RDD[String]
}
