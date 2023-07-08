# Property based testing in Scala

* https://www.scalatest.org/user_guide/property_based_testing

```
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.16.0" % "test"
```

```
sbt> testOnly MyTest -- -S 123456879
```
