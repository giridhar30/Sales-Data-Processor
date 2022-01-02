package com.presidio.data.util

import org.apache.spark.sql.SparkSession

class SparkSessionFactory(appName: String, master: String) extends Factory[SparkSession] {

  override def getInstance(): SparkSession =
    SparkSession.builder().appName(appName).master(master).getOrCreate()

}
