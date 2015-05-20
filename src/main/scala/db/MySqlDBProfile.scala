package db

import com.typesafe.config.ConfigFactory
import org.slf4j.LoggerFactory

import scala.slick.driver.{MySQLDriver, JdbcProfile}

/**
 * Created by Abdhesh.Kumar on 20-05-2015.
 */
trait MySqlDBProfile extends Profile{
  val driver: JdbcProfile = MySQLDriver

  import driver.simple._

  val logger = LoggerFactory.getLogger(this.getClass())
  private val config = ConfigFactory.load()
  private val dbDriver = config.getString("db.driver")
  private val url = config.getString("db.url")
  private val userName = config.getString("db.username")
  private val password = config.getString("db.password")

  def dbObject(): Database = {
    logger.debug(s"URL :[$url] driver: [$driver]")
    Database.forURL(url, userName, password, null, dbDriver)
  }
}
