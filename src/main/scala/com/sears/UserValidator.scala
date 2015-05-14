package com.sears

import java.util.regex.Matcher

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */

case class Address(city: String, state: String, country: String)

trait UserValidator {
  /**
   * Here dummy implementations
   */
  def isValidAddress(address: Address): Option[Address] = Some(address)

  def isValidEmail(email: String): Option[String]

  def isValidName(name: String): Option[String]
}

trait UserAddress {
  def createAddress(city: String, state: String, country: String): Address = Address(city, state, country)
}

object UserValidator extends UserValidator {
  val EMAILREGEX = """([\w\.]+)@([\w\.]+)""".r

  override def isValidEmail(email: String): Option[String] = None

  override def isValidName(name: String): Option[String] = None
}
