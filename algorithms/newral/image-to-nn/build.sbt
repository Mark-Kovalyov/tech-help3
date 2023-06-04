name := "image-to-nn"

version := "0.1"

scalaVersion := "2.13.8"

scalatestVer := "3.2.10"

libraryDependencies ++= Seq(
  "org.apache.commons" % "commons-text" % "1.9",
  "org.scalatest" %% "scalatest" % scalatestVer,
  "org.scalatest" %% "scalatest" % scalatestVer % Test
)
