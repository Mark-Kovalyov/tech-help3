import knighttour.MainDirty

class TestTour extends munit.FunSuite {

  test("Test tour 1") {
    val res = MainDirty.tour(0, 0, 0)
    assert(res.isLeft)
    val res2 = MainDirty.tour(4, 0, 0)
    assert(res2.isLeft)
  }

  test("Test tour 2") {
    val res : Either[String, List[(Int,Int)]] = MainDirty.tour(5, 0, 0)
    assert(res.isRight)
    val resList = res.getOrElse(List.empty)
    assertEquals(resList.size, 25)
    assertEquals(resList(0), (0,0))

  }

}
