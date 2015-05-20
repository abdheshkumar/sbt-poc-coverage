import com.sears.{User, UserService}

/**
 * Created by Abdhesh.Kumar on 20-05-2015.
 */
object MainApp {

  def main(args: Array[String]) {
    val id = UserService.createUser(User("abdhesh", "abdhesh@searsglobaltech.com"))
    println(s":::User  = $id::::::::::")
  }
}
