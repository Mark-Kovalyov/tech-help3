scalaVersion := "2.13.8"

name := "udp-stream"
organization := "mayton.spark"
version := "1.0"

resolvers ++= Seq(
  Resolver.mavenLocal
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core"           % "3.4.1",
  "org.apache.spark" %% "spark-sql"            % "3.4.1",
  "org.apache.spark" %% "spark-mllib"          % "3.4.1",
  "org.apache.spark" %% "spark-streaming"      % "3.4.1"
)
