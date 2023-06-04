val scala3Version = "3.1.2"

Global / onChangedBuildSource := ReloadOnSourceChanges

val opticsVersion = "3.1.0"

lazy val root = project
  .in(file("."))
  .settings(
      name := "anagram",
      version := "0.1.0-SNAPSHOT",
      scalaVersion := scala3Version,
      resolvers ++= Seq(
          Resolver.mavenLocal,
          DefaultMavenRepository
          //Resolver.file("lib", file("lib")) transactional()
          //"ScalaNLP" at "http://repo.scalanlp.org/repo/"
      ),
      libraryDependencies ++= Seq(
          "dev.optics" %% "monocle-core" % opticsVersion,
          "dev.optics" %% "monocle-macro" % opticsVersion,
          "org.scalameta" %% "munit" % "0.7.29" % Test
          //"org.scalanlp" %% "scalala" % "0.4.2"
      )
  )
