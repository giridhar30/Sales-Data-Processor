package com.presidio.data.model

import com.presidio.data.reader.OrderMethodType.OrderMethodType
import com.presidio.data.reader.ProductLine.ProductLine

case class SalesData(
                      year: Int,
                      productLine: ProductLine, //enum
                      productType: String,
                      product: String,
                      orderMethodType: OrderMethodType, //enum
                      retailerCountry: String
                    )
