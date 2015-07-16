import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import models.User

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class UserSpec extends Specification {

  "User" should {

    "Create a user from JSON" in {
      val u = uj.validate[User]
      u.get must beAnInstanceOf[User]
    }



  }
  def uj = Json.obj("username" -> "example@example.com", "password" -> "BadPassword")
}
