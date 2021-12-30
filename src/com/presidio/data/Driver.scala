package com.presidio.data

import com.presidio.data.reader.{CSVReader, Reader}
import org.apache.spark.sql.SparkSession

object Driver {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession builder () appName "SalesDataProcessingJob" master "spark://giridhar:7077" getOrCreate ()

    val reader: Reader = new CSVReader
    reader readAsDF (spark, "/home/giridhar/test/sales.csv") show 10

    spark close
  }
}
