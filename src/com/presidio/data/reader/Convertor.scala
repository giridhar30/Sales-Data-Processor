package com.presidio.data.reader

import com.presidio.data.model.SalesData
import org.apache.spark.rdd.RDD

trait Convertor {
  def stringToSalesData(fileRDD: RDD[String]): RDD[SalesData]
}
