package com.sears

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
trait UserDALDomain {
  def getUserByEmail(email: String): Option[User]

  def create(email: String): User
}

class UserDAL extends UserDALDomain {
  import  UserImplicits._
  override def getUserByEmail(email: String): Option[User] = Option(User(email))

  override def create(email: String): User = email
}
