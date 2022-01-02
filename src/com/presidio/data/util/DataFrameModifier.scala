package com.presidio.data.util

import org.apache.spark.sql.DataFrame

// this is a trait to modify the structure of a DF
trait DataFrameModifier {
  def renameColumn(df: DataFrame, existingName: String, newName: String): DataFrame
}
