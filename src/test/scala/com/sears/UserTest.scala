package com.sears

import db.H2DBProfile
import org.scalatest.FunSuite

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
class UserTest extends FunSuite with UserDALComponent with H2DBProfile {

  test("Get all Users info") {
    assert(getUserList.length === 5)
  }

  test("Add new User info") {
    val user = User("test", "test@searsglobaltech.com")
    assert(insert(user) === 6)
  }


  test("Update user info") {
    val user = User("Santosh", "santosh@mvtechlab.com", 4)
    val updatedKnol = user.copy(email = "santosh@mvtechlabs.com")
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
