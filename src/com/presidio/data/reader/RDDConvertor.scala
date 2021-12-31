package com.presidio.data.reader
import com.presidio.data.model.SalesData
import org.apache.spark.rdd.RDD

class RDDConvertor extends Convertor {
  override def stringToSalesData(fileRDD: RDD[String]): RDD[SalesData]={

    val productMap = Map("" -> ProductLine.Empty,
      "Camping Equipment" -> ProductLine.CampingEquipment,
      "Personal Accessories" -> ProductLine.PersonalAccessories,
      "Outdoor Protection" -> ProductLine.OutdoorProtection,
      "Golf Equipment" -> ProductLine.GolfEquipment,
      "Mountaineering Equipment" -> ProductLine.MountaineeringEquipment)

    val orderMap = Map("" -> OrderMethodType.Empty,
      "Telephone" -> OrderMethodType.Telephone,
      "Sales visit" -> OrderMethodType.SalesVisit,
      "Web" -> OrderMethodType.Web,
      "Special" -> OrderMethodType.Special,
      "Mail" -> OrderMethodType.Mail,
      "E-mail" -> OrderMethodType.Email,
      "Fax" -> OrderMethodType.Fax
    )

    val rdd = fileRDD.map(row => {
      val field = row.split(",")
      if(field(0).equals("Year")) SalesData(0,productMap(""),"","",orderMap(""),"")
      else SalesData(field(0).toInt, productMap(field(1)), field(2), field(3), orderMap(field(4)), field(5))
    })
    rdd
  }
}