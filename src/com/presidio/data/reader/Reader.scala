package com.presidio.data.reader

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, SparkSession}

trait Reader {
  def readAsDF(spark: SparkSession, path: String): DataFrame
  def readAsRDD(spark: SparkSession, path: String): RDD[String]
}
