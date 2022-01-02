package com.presidio.data

import com.presidio.data.reader.{CSVReader, Reader}
import com.presidio.data.transformation.df.RevenueCalculator
import org.apache.spark.sql.SparkSession


object RevenueCalculatorDriver {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession builder () appName "SalesDataProcessingJob" master "spark://keerthivasan-VirtualBox:7077" getOrCreate ()
    val reader: Reader = new CSVReader
    val FileDf=reader.readAsDF(spark, "/home/keerthivasan/Downloads/sales.csv")
    val CalculatedDf=new RevenueCalculator calculateTotalRevenue(FileDf)
    CalculatedDf.show()
    spark close
  }
}
