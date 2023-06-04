val scala3Version = "3.1.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "knight-tour",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.apache.commons" % "commons-lang3" % "3.12.0",
      "org.apache.httpcomponents" % "httpclient" % "4.5.13"
    )
  )
