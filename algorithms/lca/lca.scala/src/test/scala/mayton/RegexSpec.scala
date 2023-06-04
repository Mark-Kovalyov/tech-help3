package mayton

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.wordspec.AnyWordSpec


import scala.util.matching.Regex

class RegexSpec extends AnyFunSuite {

  def extractExt(filename : String) : Option[String] = {
    val pattern: Regex = "^(.+\\.)(c|cpp|h|rs)$".r
    filename match {
      case pattern(_, extension) => Some(extension)
      case _ => None
    }
  }

  test("Test2") {
    assert(extractExt("test.c") === Some("c"))
    assert(extractExt("test") === None)
  }

}
