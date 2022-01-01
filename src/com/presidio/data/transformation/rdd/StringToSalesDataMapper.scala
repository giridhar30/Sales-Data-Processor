package com.presidio.data.transformation.rdd

import com.presidio.data.model.{OrderMethodType, ProductLine, SalesData}
import org.apache.spark.broadcast.Broadcast
import org.apache.spark.rdd.RDD

// concrete implementation of Mapper [String to SalesData]
class StringToSalesDataMapper(enumMapBC: Broadcast[(Map[String, ProductLine.Value],
  Map[String, OrderMethodType.Value])]) extends Mapper[String, SalesData] {

  // retrieving broadcasted values
  val PRODUCT_TYPE_MAP: Map[String, ProductLine.Value] = enumMapBC.value._1
  val ORDER_METHOD_MAP: Map[String, OrderMethodType.Value] = enumMapBC.value._2

  // maps each line of the file to a SalesData object
  override def map(dataRDD: RDD[String]): RDD[SalesData] =
    dataRDD.map(row => {

      // each row is splitted at ',' that gives an array of fields in csv data
      val fields = row.split(",")

      // giving dummy SalesData for the header row of csv
      if (fields(0).equals("Year")) SalesData(0, PRODUCT_TYPE_MAP(""), "", "", ORDER_METHOD_MAP(""), "")
      // making a SalesData object using the fields and giving it
      else SalesData(fields(0).toInt,
        PRODUCT_TYPE_MAP(fields(1)),
        fields(2),
        fields(3),
        ORDER_METHOD_MAP(fields(4)),
        fields(5))
    })

}