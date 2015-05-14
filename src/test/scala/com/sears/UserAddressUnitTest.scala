package com.sears

import org.scalatest.FunSuite

/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */
class UserAddressUnitTest extends FunSuite {
  test("User address is valid") {
    val address = Address("city", "state", "country")
    assert(UserValidator.isValidAddress(address) == Some(address))
  }

  test("Create User address") {
    val address = UserService.createAddress("city", "state", "country")
    assert(address == Address("city", "state", "country"))
  }
}
