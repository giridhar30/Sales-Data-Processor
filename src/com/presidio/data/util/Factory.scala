package com.presidio.data.util

trait Factory[T] {
  def getInstance(): T
}
