import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import models.User
/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {

  "Application" should {

    "work from within a browser" in new WithBrowser {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("Yelpit!")
    }
  }

  "User" should {
  	   "save a user to the DB"  in new WithApplication {
  	  val uj = Json.obj("username" -> "example@example.com", "password" -> "BadPassword")

      val u = uj.validate[User].get
      User.create(u) must beAnInstanceOf[User]
    }

  }

}
