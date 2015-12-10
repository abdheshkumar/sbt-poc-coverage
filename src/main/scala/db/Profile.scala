package db

import scala.slick.driver.JdbcProfile

/**
 * Created by Abdhesh.Kumar on 20-05-2015.
 */
trait Profile {
  val driver: JdbcProfile

  import driver.simple._

  def dbObject(): Database
}

