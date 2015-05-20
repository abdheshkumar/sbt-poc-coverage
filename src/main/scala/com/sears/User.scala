package com.sears

import java.util.regex.Matcher

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 *
 */

case class Email(emailAddress: String) {
  private val matcher: Matcher = """([\w\.]+)@([\w\.]+)""".r.pattern.matcher(emailAddress)
  if (!matcher.matches()) {
    throw new IllegalArgumentException("Address is invalid")
  }
}

case class User(name: String, email: String, id: Int = 0)

object UserImplicits {
  implicit def stringToEmail(email: String): Email = Email(email)
}



