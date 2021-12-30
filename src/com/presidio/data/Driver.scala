package com.presidio.data

import com.presidio.data.reader.{CSVReader, Reader}
import org.apache.spark.sql.SparkSession

object Driver {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession builder () appName "SalesDataProcessingJob" master "spark://jennifer:7077" getOrCreate ()

    val reader: Reader = new CSVReader
    reader readAsRDD (spark, "/home/jennifer/Documents/sales.csv") count

    //convert to rdd[Salesdata]

    spark close
  }
}
