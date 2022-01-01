package com.presidio.data.model

// enum for OrderMethodType of input data
object OrderMethodType extends Enumeration {

  type OrderMethodType = Value

  val Empty: Value = Value("")
  val Telephone: Value = Value("Telephone")
  val SalesVisit: Value = Value("Sales visit")
  val Web: Value = Value("Web")
  val Special: Value = Value("Special")
  val Mail: Value = Value("Mail")
  val Email: Value = Value("E-mail")
  val Fax: Value = Value("Fax")
}
