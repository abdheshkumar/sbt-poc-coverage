name:="Harvester-poc"

version:="1.0"

scalaVersion:="2.11.6"

scalacOptions ++= Seq("-unchecked", "-feature","-deprecation","-language:implicitConversions","-encoding", "UTF-8")

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 80

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true