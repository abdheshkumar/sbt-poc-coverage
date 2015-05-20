package db

import com.sears.{User, UserDALComponent}
import org.scalatest.{BeforeAndAfter, FunSuite}
import scala.slick.jdbc.meta._

/**
 * Created by Abdhesh.Kumar on 20-05-2015.
 */
class TableSuite extends FunSuite with BeforeAndAfter with UserDALComponent with H2DBProfile {

  import driver.simple._

  implicit var session: Session = _

  private def insertUser() = {
    val user = User("Test User", "test@searsglobaltech.com")
    insert(user)
  }

  before {
    session = dbObject().createSession()
  }

  /*test("Database connection established successfully") {
    val dbUser = dbObject().createConnection().getMetaData.getUserName
    println(":::::::::" + dbUser)
    assert(true)
  }
*/
  test("Creating the User Schema works") {
    val tables = MTable.getTables.list
    assert(tables.size == 1)
    assert(tables.count(_.name.name.equalsIgnoreCase("user")) == 1)
  }

  test("Inserting a User works") {
    val insertCount = insertUser()
    assert(insertCount == 6)
  }


  after {
    session.close()
  }

}
