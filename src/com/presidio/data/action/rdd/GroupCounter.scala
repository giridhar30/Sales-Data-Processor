package com.presidio.data.action.rdd

import org.apache.spark.rdd.RDD

// trait for action that groups distict values and counts them
trait GroupCounter[T] {
  def groupAndCount(dataRDD: RDD[T]): Int
}
