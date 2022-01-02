package com.presidio.data.util
import org.apache.spark.sql.DataFrame

class DataFrameModifierImpl extends DataFrameModifier {

  override def renameColumn(df: DataFrame, existingName: String, newName: String): DataFrame =
    df.withColumnRenamed(existingName, newName)

}
