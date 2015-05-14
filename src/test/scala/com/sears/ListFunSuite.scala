package com.sears

import org.scalatest.FunSuite

/**
 * Created by Abdhesh.Kumar on 14-05-2015.
 */

class ListFunSuite extends FunSuite {

  test("An empty List should return true for isEmpty") {
    assert(List().isEmpty)
  }

  test("size should return the correct number of elements in a List") {
    assert(List(1, 2, 3).size == 3)
  }

  test("Calling head on an empty List should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      List.empty.head
    }
  }
}