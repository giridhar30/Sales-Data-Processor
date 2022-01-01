package com.presidio.data.reader

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
class RevenueCalculator extends Calculator {
  override def calculateTotalRevenue(fileDf: DataFrame): DataFrame ={
     //this is used to filter the large df file into small df where the country is France and revenue is not null
     val filteredDf=fileDf.filter((fileDf("Retailer country") === "France") && !(fileDf("Revenue").isNull))
    //resultDf contains the sum of the revenue using the filteredDf
     val resultDf = filteredDf.agg(sum("Revenue").cast("long"))
     resultDf
  }


}
