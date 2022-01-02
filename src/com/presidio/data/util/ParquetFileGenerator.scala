package com.presidio.data.util

import org.apache.spark.sql.DataFrame

class ParquetFileGenerator(df: DataFrame) extends FileGenerator {

  override def generate(): Unit =
    df.write.parquet("/home/giridhar/test/FranceRevenue")

}
