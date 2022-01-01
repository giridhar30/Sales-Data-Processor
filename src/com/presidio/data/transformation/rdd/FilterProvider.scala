package com.presidio.data.transformation.rdd

import org.apache.spark.rdd.RDD

// trait for filter transformation
trait FilterProvider[T] {
  def filter(dataRDD: RDD[T]): RDD[T]
}
