package com.presidio.data.constants

import com.presidio.data.model.{OrderMethodType, ProductLine}

// stores data that are broadcasted to the workers
object BroadcastData {

  // maps String to respective ProductLine Enum
  val PRODUCT_LINE_MAP = Map("" -> ProductLine.Empty,
    "Camping Equipment" -> ProductLine.CampingEquipment,
    "Personal Accessories" -> ProductLine.PersonalAccessories,
    "Outdoor Protection" -> ProductLine.OutdoorProtection,
    "Golf Equipment" -> ProductLine.GolfEquipment,
    "Mountaineering Equipment" -> ProductLine.MountaineeringEquipment)

  // maps String to respective OrderMethodType Enum
  val ORDER_METHOD_MAP = Map("" -> OrderMethodType.Empty,
    "Telephone" -> OrderMethodType.Telephone,
    "Sales visit" -> OrderMethodType.SalesVisit,
    "Web" -> OrderMethodType.Web,
    "Special" -> OrderMethodType.Special,
    "Mail" -> OrderMethodType.Mail,
    "E-mail" -> OrderMethodType.Email,
    "Fax" -> OrderMethodType.Fax
  )
}
