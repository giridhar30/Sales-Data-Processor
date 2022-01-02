package com.presidio.data

import com.presidio.data.constants.SparkData._
import com.presidio.data.reader.CSVReader
import com.presidio.data.transformation.df.RevenueCalculator
import com.presidio.data.util.ParquetFileGenerator
import org.apache.spark.sql.SparkSession

// driver program for total revenue calculating job
object RevenueCalculatorDriver {

  def main(args: Array[String]): Unit = {
    // getting spark session for our spark cluster
    val spark = SparkSession.builder()
                            .appName(REVENUE_CALCULATOR_APP_NAME)
                            .master(MASTER)
                            .getOrCreate()

    // reading the csv file as a DataFrame(DF)
    val reader = new CSVReader
    val fileDf = reader.readAsDF(spark, CSV_PATH)

    // calculating the total revenue
    val resultDf = new RevenueCalculator().calculateTotalRevenue(fileDf, "France")

    // writing the result as a parquet
    new ParquetFileGenerator(resultDf).generate()

    // displaying the result
    resultDf.foreach(each => println("Total Revenue By France" + each.get(0) + " dollars"))

    // closing the spark session
    spark.close()
  }
}
