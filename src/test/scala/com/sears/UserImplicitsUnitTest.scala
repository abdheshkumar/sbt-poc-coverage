package com.sears

/**
 * Created by abdhesh on 5/20/15.
 */
class UserImplicitsUnitTest extends ListFunSuite {

  test("User email should convert into Email object") {
    import UserImplicits._
    val emailObj: Email = "demo@searsglobaltech.com"
    assert(emailObj.emailAddress == "demo@searsglobaltech.com")
  }
}
