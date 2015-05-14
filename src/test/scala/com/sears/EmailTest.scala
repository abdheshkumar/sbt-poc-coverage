package com.sears

import org.scalatest.FunSuite

/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */
class EmailTest extends FunSuite {
  test("Email with valid address") {
    val email: Email = Email("abdhesh.kumar@searsglobaltech.com")
    assert(email != null)
  }

  test("Email with invalid address") {
    intercept[IllegalArgumentException] {
      Email("example.com")
    }
  }
}
