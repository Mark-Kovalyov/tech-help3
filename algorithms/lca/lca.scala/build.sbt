val scala3Version = "3.1.2"
val scalatestVer = "3.2.12"

lazy val root = project
  .in(file("."))
  .settings(
    name := "lca",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++=Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
      "org.scalatest" %% "scalatest" % scalatestVer % Test
    )
  )
