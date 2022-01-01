package com.presidio.data.constants

// stores data that are required to configure spark session and to read data
object SparkData {

  // data for spark session for different jobs
  val PRODUCT_TYPE_COUNTER_APP_NAME = "ProductTypeCountingJob"
  val REVENUE_CALCULATOR_APP_NAME = "RevenueCalculatingJob"
  val MASTER = "spark://giridhar:7077"

  // path of the csv file which is the input data
  val CSV_PATH = "/home/giridhar/test/sales.csv"
}
