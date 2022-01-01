package com.presidio.data.reader

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.DataFrame

trait Calculator {
  def calculateTotalRevenue(fileDf: DataFrame):DataFrame
}
