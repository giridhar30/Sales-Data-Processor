package com.presidio.data.transformation.rdd
import org.apache.spark.rdd.RDD

// concrete implementation of GroupCounter
class ProductTypeGroupCounter extends GroupCounter[String] {

  // groups distict String vales as a map and finally counts them
  override def groupAndCount(dataRDD: RDD[String]): Int =
    dataRDD countByValue () count (_ => true)

}
