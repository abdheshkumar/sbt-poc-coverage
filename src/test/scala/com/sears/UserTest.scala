package com.sears

import org.scalatest.FunSuite

/**
 * Created by Abdhesh.Kumar on 13-05-2015.
 */
class UserTest extends FunSuite {
  test("Get User email") {
    val user = UserService.createUser("abdhesh.kumar@searsglobaltech.com")
    assert(UserService.getUser(user.name) == Some(User("abdhesh.kumar@searsglobaltech.com")))
  }

  test("User email is not valid") {
    assert(UserValidator.isValidEmail("example.com") == None)
  }

  test("User name is not valid") {
    assert(UserValidator.isValidName("exam@#@432342#") == None)
  }
}
