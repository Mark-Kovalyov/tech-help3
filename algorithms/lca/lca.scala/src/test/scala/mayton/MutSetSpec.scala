package mayton

import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable
import scala.collection.mutable.Map

class MutSetSpec extends AnyWordSpec {

  "mutable set" should {
    "works correctly :)" in {
      val mset1 = mutable.Set[Int]()
      mset1 += 2
      mset1 += 3
      assert(mset1.contains(2))
      assert(!mset1.contains(5))
      assert(mset1.size === 2)
    }

  }


}
