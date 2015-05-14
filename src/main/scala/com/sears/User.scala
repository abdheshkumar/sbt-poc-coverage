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

case class User(name: String)

object UserImplicits {
  implicit def emailToUser(email: String): User = User(email)
}



