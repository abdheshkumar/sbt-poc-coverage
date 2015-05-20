package db

import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory

import scala.slick.driver.{H2Driver, JdbcProfile}

/**
 * Created by Abdhesh.Kumar on 20-05-2015.
 */
trait H2DBProfile extends Profile {
  val driver: JdbcProfile = H2Driver

  import driver.simple._

  val logger = LoggerFactory.getLogger(this.getClass())
  private val config = ConfigFactory.load()

  private val dbDriver = config.getString("db.driver")
  private val url = config.getString("db.url")

  def dbObject(): Database = {
    logger.debug(s"URL :[$url] driver: [$driver]")
    Database.forURL(url, driver = dbDriver)
  }
}
