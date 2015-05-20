package com.sears

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
class UserService(useDAL: UserDALComponent) extends UserAddress {

  import UserImplicits._

  def createUser(user: User): Int = useDAL.insert(user)

  def getUserByEmail(email: String): Option[User] = useDAL.getByEmail(email)

  def getById(id: Int): Option[User] = useDAL.findById(id)

  def addUser(user: User): Option[Int] = {
    useDAL.getByEmail(user.email) match {
      case None => Option(useDAL.insert(user))
      case Some(_user) => None
    }
  }
}

object UserService extends UserService(UserDAL)
