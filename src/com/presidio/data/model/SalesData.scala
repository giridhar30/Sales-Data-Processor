package com.presidio.data.model

// DTO case class for input data
case class SalesData (
    year: Int,
    productLine: ProductLine.ProductLine,
    productType: String,
    product: String,
    orderMethodType: OrderMethodType.OrderMethodType,
    retailerCountry: String
) extends Serializable
