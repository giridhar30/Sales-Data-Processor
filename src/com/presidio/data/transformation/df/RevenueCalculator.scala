package com.presidio.data.transformation.df

import com.presidio.data.util.DataFrameModifierImpl
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

/*
* concrete implementation of Calculator Trait 
* calculates the total revenue using DataFrame and SQL 
*/
class RevenueCalculator extends Calculator {

  override def calculateTotalRevenue(fileDf: DataFrame, country: String): DataFrame = {

     // this is used to filter the large df file into small df where the country is France and revenue is not null
     val filteredDf=fileDf.filter((fileDf("Retailer country") === country) && !fileDf("Revenue").isNull)

     // resultDf contains the sum of the revenue using the filteredDf
     val resultDf = filteredDf.agg(sum("Revenue").cast("long"))

    // returns resultDf with column properly named
     new DataFrameModifierImpl().renameColumn(
       resultDf, "CAST(sum(Revenue) AS BIGINT)", "TOTAL_REVENUE"
     )
  }

}
