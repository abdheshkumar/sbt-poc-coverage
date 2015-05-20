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

  private def createSchema() = (userTable.ddl).create

  private def insertUser() = {
    val user = User("Test User", "test@searsglobaltech.com")
    insert(user)
  }

  before {
    session = dbObject().createSession()
  }

  test("Creating the User Schema works") {
    val tables = MTable.getTables.list
    assert(tables.size == 1)
    assert(tables.count(_.name.name.equalsIgnoreCase("user")) == 1)
  }

  test("Inserting a User works") {
    val insertCount = insertUser()
    assert(insertCount == 1)
  }

  test("Query Users works") {
    insertUser()
    val results = userTable.list
    assert(results.size == 1)
  }

  after {
    session.close()
  }

}
