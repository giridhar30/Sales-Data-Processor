package com.presidio.data.model

// enum for ProductLine of input data
object ProductLine extends Enumeration {

  type ProductLine = Value

  val Empty: Value = Value("")
  val CampingEquipment: Value = Value("Camping Equipment")
  val PersonalAccessories: Value = Value("Personal Accessories")
  val OutdoorProtection: Value = Value("Outdoor Protection")
  val GolfEquipment: Value = Value("Golf Equipment")
  val MountaineeringEquipment: Value = Value("Mountaineering Equipment")
}
