package mayton

import org.scalatest.wordspec.AnyWordSpec

import scala.collection.mutable
import scala.collection.mutable.Map

class MutMapSpec extends AnyWordSpec {

  "mmap" should {
    "provide neutral element" in {
      val mmap = mutable.Map[String,Integer]()
      assert(mmap.isEmpty)
    }

    "provide access to values" in {
      val mmap = mutable.Map[String,Integer]()
      mmap += ("c" -> 555)
      assert(mmap("c") == 555)
    }

    "update value by key" in {
      val mmap = mutable.Map[String,Integer]()
      mmap += ("c" -> 555)
      mmap("c") = 777
      assert(mmap("c") == 777)
    }

  }

}
