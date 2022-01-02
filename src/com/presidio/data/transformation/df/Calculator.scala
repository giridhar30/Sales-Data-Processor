package com.presidio.data.transformation.df

import org.apache.spark.sql.DataFrame

// this trait calculator is used to calculate the total revenue in the provided dataframe
trait Calculator {
  def calculateTotalRevenue(fileDf: DataFrame, country: String): DataFrame
}
