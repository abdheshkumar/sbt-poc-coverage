package com.sears

import db.H2DBProfile
import org.scalatest.FunSuite

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
class UserTest extends FunSuite with UserDALComponent with H2DBProfile {

  test("Add new User info") {
    val user = User("test", "test@searsglobaltech.com")
    assert(insert(user) === 1)
  }

  test("Get all Users info") {
    val user = User("test", "test@searsglobaltech.com")
    insert(user)
    assert(getUserList.length === 2)
  }

  test("Update user info") {
    val user = User("test", "test@searsglobaltech.com")
    insert(user)
    val updatedKnol = user.copy(email = "demo@searsglobaltech.com")
    assert(update(updatedKnol) === 1)
  }

  test("Delete user info") {
    assert(delete(1) === 1)
  }

  test("User email is not valid") {
    assert(UserValidator.isValidEmail("example.com") == None)
  }

  test("User name is not valid") {
    assert(UserValidator.isValidName("exam@#@432342#") == None)
  }
}