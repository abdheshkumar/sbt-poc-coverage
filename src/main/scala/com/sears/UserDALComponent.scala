package com.sears

import db.{MySqlDBProfile, Profile}

import scala.slick.lifted.ProvenShape

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
trait UserDALComponent {
  this: Profile =>

  import driver.simple._

  class UserTable(tag: Tag) extends Table[User](tag, "user") {
    def id: Column[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)

    def name: Column[String] = column[String]("name", O.NotNull)

    def email: Column[String] = column[String]("email", O.NotNull)

    def * : ProvenShape[User] = (name, email, id) <>(User.tupled, User.unapply)
  }

  val userTable = TableQuery[UserTable]

  def getUserList(): List[User] = {
    dbObject.withSession { implicit session: Session => userTable.list }
  }

  def getByEmail(email: Email): Option[User] = {
    dbObject.withSession { implicit session: Session =>
      userTable.filter {
        _.email === email.emailAddress
      }.list.headOption
    }
  }

  def findById(id: Int): Option[User] = {
    dbObject().withSession {
      implicit session: Session =>
        userTable.filter(_.id === id).list.headOption
    }
  }

  def insert(user: User): Int = {
    dbObject.withSession { implicit session: Session =>
      userTable.returning(userTable.map(_.id)).insert(user)
    }
  }

  def update(user: User): Int = {
    dbObject.withSession { implicit session: Session =>
      userTable.filter {
        _.id === user.id
      }.update(user)
    }
  }


  def delete(id: Int): Int = {
    dbObject.withSession { implicit session: Session =>
      userTable.filter {
        _.id === id
      }.delete
    }
  }

}

object UserDAL extends UserDALComponent with MySqlDBProfile
