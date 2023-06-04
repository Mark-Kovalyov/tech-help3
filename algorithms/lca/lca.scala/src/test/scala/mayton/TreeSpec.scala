package mayton

import org.scalatest.wordspec.AnyWordSpec

class TreeSpec extends AnyWordSpec {

  //     1
  //    / \
  //   2  3
  //       \
  //       4

  val n1: Node[Int] = Node(1)
  val n2: Node[Int] = Node(2)
  val n3: Node[Int] = Node(3)
  val n4: Node[Int] = Node(4)

  n4.parent = Some(n3)
  n3.parent = Some(n1)
  n2.parent = Some(n1)

  "stepUp" should {
    "give None when overflow" in {
      assert(stepUp(Some(n1),1).isEmpty)
      assert(stepUp(Some(n1),9999).isEmpty)
    }
    "give correct value when step is in bound of root and leeaves" in {
      assert(stepUp(Some(n4),1) === Some(n3))
      assert(stepUp(Some(n4),1) === Some(n3))
    }
  }

  "lca2" should {
    "works correctly" in {
      assert(lca2(n1,n1) === Some(n1))
      assert(lca2(n2,n3) === Some(n1))
      assert(lca2(n2,n4) === Some(n1))
      assert(lca2(n3,n4) === Some(n3))
    }
  }

  "lca3" should {
    "give ancestor 1 when 2 and 3 child picked" in {
      assert(lca3(n1,n1) === Some(n1))
      assert(lca3(n2,n3) === Some(n1))
      assert(lca3(n2,n4) === Some(n1))
      assert(lca3(n3,n4) === Some(n3))
    }
  }

  "lca4" should {
    "give ancestor 1 when 2 and 3 child picked" in {
      assert(lca4(n1,n1) === Some(n1))
      assert(lca4(n2,n3) === Some(n1))
      assert(lca4(n2,n4) === Some(n1))
      assert(lca4(n3,n4) === Some(n3))
    }
  }

  "lca5" should {
    "give ancestor 1 when 2 and 3 child picked" in {
      assert(lca5(n1,n1) === Some(n1))
      assert(lca5(n2,n3) === Some(n1))
      assert(lca5(n2,n4) === Some(n1))
      assert(lca5(n3,n4) === Some(n3))
    }
  }

  "lca6" should {
    "give ancestor 1 when 2 and 3 child picked" in {
      assert(lca6(n1,n1) === Some(n1))
      assert(lca6(n2,n3) === Some(n1))
      assert(lca6(n2,n4) === Some(n1))
      assert(lca6(n3,n4) === Some(n3))
    }
  }

}
