package com.sears

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
class UserService(useDAL: UserDALDomain) extends UserAddress{
  def createUser(email: String): User = useDAL.create(email)

  def getUser(email: String): Option[User] = useDAL.getUserByEmail(email)
}

object UserService extends UserService(new UserDAL)
