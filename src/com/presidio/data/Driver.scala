package com.presidio.data

import com.presidio.data.reader.{CSVReader, RDDConvertor, Reader, RevenueCalculator}
import org.apache.spark.sql.SparkSession

object Driver {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("SalesDataProcessingJob").master("spark://jennifer:7077").getOrCreate()

    val reader: Reader = new CSVReader
    val rdd = reader.readAsRDD(spark, "/home/jennifer/Documents/sales.csv")

    //convert to Array[SalesData]
    val conv = new RDDConvertor()
    val salesData =  conv.stringToSalesData(rdd)

    println(salesData.count())

    spark.close()
  }
}
