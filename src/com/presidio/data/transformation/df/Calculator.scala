package com.presidio.data.transformation.df

import org.apache.spark.sql.DataFrame

// This trait calculator is used to calculating the total revenue in the provided dataframe
trait Calculator {
  def calculateTotalRevenue(fileDf: DataFrame): DataFrame
}
