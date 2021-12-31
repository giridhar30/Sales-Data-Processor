package com.presidio.data.reader

object OrderMethodType extends Enumeration {
  type OrderMethodType = Value
  val Empty = Value("")
  val Telephone = Value("Telephone")
  val SalesVisit = Value("Sales visit")
  val Web = Value("Web")
  val Special = Value("Special")
  val Mail = Value("Mail")
  val Email = Value("E-mail")
  val Fax = Value("Fax")
}
