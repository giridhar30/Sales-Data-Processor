package com.presidio.data.transformation.rdd

import com.presidio.data.model.{ProductLine, SalesData}
import org.apache.spark.rdd.RDD

// concrete implementation of filter provider
class SalesDataFilterProvider extends FilterProvider[SalesData] {

  // filters SalesData, only that has Golf Equipment ProductLine
  override def filter(dataRDD: RDD[SalesData]): RDD[SalesData] =
    dataRDD filter (_.productLine equals ProductLine.GolfEquipment)

}
