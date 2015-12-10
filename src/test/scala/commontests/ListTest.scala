package commontests

import java.util

import org.junit.runner.RunWith
import org.mockito.Matchers._
import org.mockito.Mockito._
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

/**
 * Created by abdhesh on 8/25/15.
 */

@RunWith(classOf[JUnitRunner])
class ListTest extends FunSuite with MockitoSugar {

  test("How about some stubbing?") {
    //You can mock concrete classes, not only interfaces
    val mockedList = mock[util.LinkedList[String]]

    //stubbing
    when(mockedList.get(0)).thenReturn("first")
    //when(mockedList.get(1)).thenThrow(new RuntimeException())
    when(mockedList.get(1)).thenReturn("Second")

    //following prints "first"
    println(mockedList.get(0))

    //following throws runtime exception
    println(mockedList.get(1))

    //following prints "null" because get(999) was not stubbed
    println(mockedList.get(999))

    //Although it is possible to verify a stubbed invocation, usually it's just redundant
    //If your code cares what get(0) returns then something else breaks (often before even verify() gets executed).
    //If your code doesn't care what get(0) returns then it should not be stubbed. Not convinced? See here.
    verify(mockedList).get(0)
  }

  test("Argument matchers") {
    val mockedList = mock[util.LinkedList[String]]
    //stubbing using built-in anyInt() argument matcher
    when(mockedList.get(anyInt())).thenReturn("element")

    //stubbing using custom matcher (let's say isValid() returns your own matcher implementation):
    //when(mockedList.contains(argThat(isValid()))).thenReturn("element")
    //following prints "element"
    println(mockedList.get(999))

    //you can also verify using an argument matcher
    verify(mockedList).get(anyInt())
  }

  test("Verifying exact number of invocations / at least x / never") {
    val mockedList = mock[util.LinkedList[String]]
    //using mock
    mockedList.add("once")

    mockedList.add("twice")
    mockedList.add("twice")

    mockedList.add("three times")
    mockedList.add("three times")
    mockedList.add("three times")

    //following two verifications work exactly the same - times(1) is used by default
    verify(mockedList).add("once")
    verify(mockedList, times(1)).add("once")

    //exact number of invocations verification
    verify(mockedList, times(2)).add("twice")
    verify(mockedList, times(3)).add("three times")

    //verification using never(). never() is an alias to times(0)
    verify(mockedList, never()).add("never happened")

    //verification using atLeast()/atMost()
    verify(mockedList, atLeastOnce()).add("three times")
    //verify(mockedList, atLeast(2)).add("five times")
    verify(mockedList, atMost(5)).add("three times")
  }

  test("Stubbing void methods with exceptions") {
    val mockedList = mock[util.LinkedList[String]]
    doThrow(new RuntimeException()).when(mockedList).clear()

    //following throws RuntimeException:
    intercept[RuntimeException](mockedList.clear())
  }

  test("Verification in order") {
    // A. Single mock whose methods must be invoked in a particular order
    val singleMock = mock[java.util.List[String]]
    //using a single mock
    singleMock.add("was added first")
    singleMock.add("was added second")

    //create an inOrder verifier for a single mock
    val inorder = inOrder(singleMock);

    //following will make sure that add is first called with "was added first, then with "was added second"
    inorder.verify(singleMock).add("was added first")
    inorder.verify(singleMock).add("was added second")

    // B. Multiple mocks that must be used in a particular order
    val firstMock = mock[java.util.List[String]]
    val secondMock = mock[java.util.List[String]]

    //using mocks
    firstMock.add("was called first");
    secondMock.add("was called second");

    //create inOrder object passing any mocks that need to be verified in order
    val inOrder1 = inOrder(firstMock, secondMock);

    //following will make sure that firstMock was called before secondMock
    inOrder1.verify(firstMock).add("was called first");
    inOrder1.verify(secondMock).add("was called second");

    // Oh, and A + B can be mixed together at will

  }

  test("Spying on real objects") {
    val list = new util.LinkedList[String]()
    val spiedList = spy(list)
    //optionally, you can stub out some methods:
    when(spiedList.size).thenReturn(100)

    //using the spy calls *real* methods
    spiedList.add("one")
    spiedList.add("two")

    //prints "one" - the first element of a list
     println(spiedList.get(0))

    //size() method was stubbed - 100 is printed
     println(spiedList.size())

    //optionally, you can verify
    verify(spiedList).add("one");
    verify(spiedList).add("two");
  }

  test("Important gotcha on spying real objects!"){
    val list = new util.LinkedList[String]()
    val spiedList = spy(list);
    spiedList.add(1,"Hello one")
    //Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
    //when(spiedList.get(0)).thenReturn("foo")

    //You have to use doReturn() for stubbing
    doReturn("foo").when(spiedList).get(0)
    doReturn("any foo").when(spiedList).get(anyInt())
    println(spiedList.get(10))
  }
}
