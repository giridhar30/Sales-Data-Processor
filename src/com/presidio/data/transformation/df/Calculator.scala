package com.presidio.data.transformation.df

import org.apache.spark.sql.DataFrame

//
trait Calculator {
  def calculateTotalRevenue(fileDf: DataFrame): DataFrame
}
