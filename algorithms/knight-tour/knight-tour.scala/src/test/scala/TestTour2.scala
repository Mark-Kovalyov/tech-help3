import knighttour.MainDirty

class TestTour2 extends munit.FunSuite {
  test("Test demo list") {
    val list = MainDirty.demoList(8)

    assertEquals(list.length,8)

    assertEquals(list.head, (7,7))

  }
}
