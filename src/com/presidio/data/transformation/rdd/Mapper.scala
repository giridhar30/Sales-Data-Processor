package com.presidio.data.transformation.rdd

import org.apache.spark.rdd.RDD

// trait for map transformation, maps from RDD[T] to RDD[U]
trait Mapper[T, U] extends Serializable {
  def map(dataRDD: RDD[T]): RDD[U]
}
