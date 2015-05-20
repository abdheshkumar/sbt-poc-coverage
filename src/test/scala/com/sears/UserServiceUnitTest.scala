package com.sears

import db.H2DBProfile
import org.scalatest.FunSuite
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.mockito.Matchers._

/**
 * Created by abdhesh on 5/20/15.
 */
class UserServiceUnitTest extends FunSuite with MockitoSugar {

  object UserTestService extends UserService(new UserDALComponent with H2DBProfile)

  test("UserTestService should create user") {
    val user = User("demo2", "demo2@searsglobal.com")
    val id = UserTestService.createUser(user)
    assert(id == 6)
  }

  test("Get User By email") {
    val user = UserTestService.getUserByEmail("abdhesh.kumar@searsglobaltech.com")
    assert(user.isDefined)
  }

  test("Get User By id") {
    val user = UserTestService.getById(1)
    assert(user.isDefined)
  }

  test("Add User that is not register with us") {
    val mockUserDALObject = mock[UserDALComponent]
    val uService = new UserService(mockUserDALObject)
    val user = User("demo", "demo@searsglobaltech.com", 1)
    when(mockUserDALObject.getByEmail(any[Email])).thenReturn(None)
    when(mockUserDALObject.insert(any[User])).thenReturn(1)
    val result = uService.addUser(user)
    assert(result.isDefined)
  }

  test("User is already registered with us") {
    val mockUserDALObject = mock[UserDALComponent]
    val uService = new UserService(mockUserDALObject)
    val user = User("demo", "demo@searsglobaltech.com", 1)
    when(mockUserDALObject.getByEmail(any[Email])).thenReturn(Some(user))
    when(mockUserDALObject.insert(any[User])).thenReturn(1)
    val result = uService.addUser(user)
    assert(result.isEmpty)
  }
}
