import sbt._


object Version {
  val scala = "2.11.5"
  val scalaTest = "2.2.4"
  val junit = "4.12"
  val mockito = "1.10.19"
  val slick = "2.1.0"
  val mysql = "5.1.27"
  val h2 = "1.3.175"
  val slf4j = "1.7.6"
  val scalacheck = "1.11.6"
}

object Library {
  val mockitoAll    = "org.mockito"        %  "mockito-all"          % Version.mockito
  val scalaTest     = "org.scalatest"      %% "scalatest"            % Version.scalaTest
  val scalacheck    = "org.scalacheck"     %% "scalacheck"           % Version.scalacheck
  val junit         = "junit"              % "junit"                % Version.junit
  val slick         = "com.typesafe.slick" %% "slick"                % Version.slick
  val slf4j         = "org.slf4j"          %  "slf4j-nop"            % Version.slf4j
  val h2            = "com.h2database"     %  "h2"                   % Version.h2
  val mysql         = "mysql"              %  "mysql-connector-java" % Version.mysql

}

object Scopes{
  val test = "test"
}

object Dependencies {
  import Library._
  import Scopes._

  val dependencies = Seq(
    mysql,
    h2,
    slick,
    slf4j,
    scalaTest      % test,
    mockitoAll     % test,
    scalacheck     % test,
    junit          % test
  )
}