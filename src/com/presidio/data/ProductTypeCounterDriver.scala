package com.presidio.data

import com.presidio.data.constants.BroadcastData._
import com.presidio.data.constants.SparkData._
import com.presidio.data.reader.CSVReader
import com.presidio.data.transformation.rdd.{ProductTypeGroupCounter, SalesDataFilterProvider, SalesDataToProductTypeMapper, StringToSalesDataMapper}
import org.apache.spark.sql.SparkSession

object ProductTypeCounterDriver {

  def main(args: Array[String]): Unit = {
    // getting spark session for our spark cluster
    val spark = SparkSession.builder()
                            .appName(PRODUCT_TYPE_COUNTER_APP_NAME)
                            .master(MASTER)
                            .getOrCreate()

    // broadcasting the 'String to Enum' maps
    val enumMapBC = spark.sparkContext.broadcast((PRODUCT_LINE_MAP, ORDER_METHOD_MAP))

    // reading the csv file data as RDD[String]
    val reader = new CSVReader
    val fileRDD = reader.readAsRDD(spark, CSV_PATH)

    /*
     * Transformation - 1
     * applying map transformation to convert
     * RDD[String] to RDD[SalesData]
     */
    val salesDatamapper = new StringToSalesDataMapper(enumMapBC)
    val mappedRDD =  salesDatamapper.map(fileRDD)

    /*
     * Transformation - 2
     * applying filter transformation that filters
     * SalesData that has ProductLine of Golf Equipmaent only
     */
    val salesDataFilter = new SalesDataFilterProvider
    val filteredRDD = salesDataFilter.filter(mappedRDD)

    /*
     * Transformation - 3
     * applying map transformation that maps
     * each SalesData to its ProductType[String]
     */
    val prodTypeMapper = new SalesDataToProductTypeMapper
    val prodTypeMappedRDD = prodTypeMapper.map(filteredRDD)

    /*
     * Action
     * applying countByValue that finds
     * count of each distinct value of RDD and returns a map.
     * count of the map is then calculated, which is the result
     */
    val groupCounter = new ProductTypeGroupCounter
    val result = groupCounter.groupAndCount(prodTypeMappedRDD)

    // printing result to the console
    println("No of Product Types for Product Line 'Golf Equipment': " + result)

    // closing the spark session
    spark.close()
  }
}
