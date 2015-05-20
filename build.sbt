name := "Harvester-poc"

version := "1.0"

scalaVersion := "2.11.6"

scalacOptions ++= Seq("-unchecked", "-feature", "-deprecation", "-language:implicitConversions", "-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "org.scalatest"         % "scalatest_2.11"       % "2.2.4"  % "test",
  "org.mockito"           % "mockito-core"         % "1.10.8" % "test",
  "org.scalacheck"        %% "scalacheck"          % "1.11.6" % "test",
  "com.typesafe.slick"    %% "slick"               % "2.1.0",
  "org.slf4j"             % "slf4j-nop"            % "1.6.4",
  "com.h2database"        % "h2"                   % "1.3.175",
  "mysql"                 % "mysql-connector-java" % "5.1.27")

//ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 80

//ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true