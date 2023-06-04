# Testing

## Links

*

## Base Spec with TableDriven

```
class DataTable extends BaseSpec with TableDrivenPropertyChecks {
  private val dataTable = Table(
       ("a","b","c"),
       (1,2,3)
    )

  it should "compute sum with table" in {
    forAll(dataTable) {
      (a,b,c) => a + b shouldBe c
    }
  }
}
```

## Other

build.sbt
```
val scala3Version = "3.1.0"
val scalatestVer = "3.2.10"
lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-simple",
    version := "0.1.0",
    scalaVersion := scala3Version,
    libraryDependencies ++=Seq(
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.scalatest" %% "scalatest" % scalatestVer,
      "org.scalatest" %% "scalatest" % scalatestVer % Test
    )
  )
```
### AnyFunSuite
```
class StatisticsSuite extends AnyFunSuite {
  test("2 + 2 = 4") {
    assert(2 + 2 == 4)
  }
  test("Division by zero always throws error") {
    assertThrows[ArithmeticException](1 / 0)
  }
}
```
### AnyFunSpec
```
import org.scalactic.Tolerance.convertNumericToPlusOrMinusWrapper
import org.scalactic.TolerantNumerics
import org.scalatest.funspec.AnyFunSpec

import scala.math.sin

class StatisticsSpec extends AnyFunSpec {

  describe("sinus function") {
    it ("should give 0 wher fi = 0") {
      assert(sin(0.0) === 0.0 +- 0.001)
    }
    it ("should give 1/2 wher fi = 30 degrees") {
      assert(sin(Math.PI / 6.0) === 0.5 +- 0.001)
    }
  }

}  
```
### StatisticAnyWordSpec
```
class StatisticAnyWordSpec extends AnyWordSpec {

  "A factorial function" should {
    "give 1 when x = 1 or x = 0" in {
      assert(fact(0) == 1)
      assert(fact(1) == 1)
    }
    "throws an exception wher argument is negative" in {
      assertThrows[AssertionError](fact(-1))
    }
  }
}
```
### Property-based (*)
```
class StatisticPropSpec extends AnyPropSpec {

}
```
### Reflection property-based
```
class StatRefSpec extends RefSpec {

}
```
