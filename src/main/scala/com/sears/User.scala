package com.sears

/**
  * Created by Abdhesh.Kumar on 13-05-2015.
 *
 */

case class User(email: String)

object UserImplicits {
  implicit def emailToUser(email: String): User = User(email)
}



