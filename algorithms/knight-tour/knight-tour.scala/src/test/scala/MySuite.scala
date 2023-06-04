import scala.collection.mutable
import scala.collection.mutable.ListBuffer

class MySuite extends munit.FunSuite {

  test("Test 2 dimension arr") {
    val desk : Array[Array[Int]] = Array.ofDim[Int](8, 8)
    desk(0)(0) = 1
    assertEquals(desk(0)(0),1)
  }

  test("Test stack") {
    val stack : mutable.Stack[Int] = mutable.Stack[Int]()
    stack.push(777)
    assertEquals(stack.size, 1)
    stack.push(1111)
    assertEquals(stack.size, 2)
    assertEquals(stack.pop(), 1111)
    assertEquals(stack.pop(), 777)
  }

  test("Test List Buf") {
    val current : ListBuffer[(Int,Int)] = ListBuffer()
    current += ((1,1))
    current ++= List((2,2),(3,3))

    assertEquals(current.size, 3)

    assertEquals(current.remove(0), (1,1))
    assertEquals(current.remove(0), (2,2))
    assertEquals(current.remove(0), (3,3))

    assertEquals(current.size, 0)

    current ++= List((5,5),(7,7))

    assertEquals(current.remove(current.size - 1), (7,7))
    assertEquals(current.remove(current.size - 1), (5,5))
  }
}
