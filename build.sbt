import de.johoop.cpd4sbt.CopyPasteDetector._
import de.johoop.findbugs4sbt.FindBugs._

name := "Harvester-poc"

version := "1.0"

scalaVersion := Version.scala

scalacOptions ++= Seq("-unchecked", "-feature", "-deprecation", "-language:implicitConversions", "-encoding", "UTF-8")


libraryDependencies ++= Dependencies.dependencies

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 80

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

releaseSettings

scalariformSettings

cpdSettings

findbugsSettings