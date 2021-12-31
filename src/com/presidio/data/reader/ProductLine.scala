package com.presidio.data.reader

object ProductLine extends Enumeration {
  type ProductLine = Value
  val Empty = Value("")
  val CampingEquipment = Value("Camping Equipment")
  val PersonalAccessories = Value("Personal Accessories")
  val OutdoorProtection = Value("Outdoor Protection")
  val GolfEquipment = Value("Golf Equipment")
  val MountaineeringEquipment = Value("Mountaineering Equipment")
}
