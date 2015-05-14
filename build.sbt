name := "Harvester-poc"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-unchecked", "-feature", "-deprecation", "-language:implicitConversions", "-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.mockito" % "mockito-core" % "1.10.8" % "test",
  "org.scalacheck" %% "scalacheck" % "1.11.6" % "test")

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 80

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true