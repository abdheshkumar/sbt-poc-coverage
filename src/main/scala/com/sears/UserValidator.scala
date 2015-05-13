package com.sears

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */

trait UserValidator {
  def isValidEmail(email: String): Option[String]

  def isValidName(name: String): Option[String]
}

object UserValidator extends UserValidator {
  override def isValidEmail(email: String): Option[String] = None

  override def isValidName(name: String): Option[String] = None
}
