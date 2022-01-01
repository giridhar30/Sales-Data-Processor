package com.presidio.data.transformation.rdd
import com.presidio.data.model.SalesData
import org.apache.spark.rdd.RDD

// concrete implementation of Mapper [SalesData to String]
class SalesDataToProductTypeMapper extends Mapper[SalesData, String] {

  // maps each SalesData to its ProductLine
  override def map(dataRDD: RDD[SalesData]): RDD[String] =
    dataRDD map (_.productType)

}
