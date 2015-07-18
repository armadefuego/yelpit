package models

import play.api.db._
import play.api.Play.current
import play.api.libs.json._
import play.api.libs.functional.syntax._

import anorm._
import anorm.SqlParser._

case class User(username: String, password: String)

object User {
  
  // -- Parsers

  // -- Json
  implicit val userFormat = Json.format[User]
  implicit val userWrites: Writes[User] = (
    (JsPath \ "username").write[String] and
    (JsPath \ "password").write[String]
    )(unlift(User.unapply))

  implicit val userReads: Reads[User] = (
    (JsPath \ "username").read[String] and
    (JsPath \ "password").read[String]
  )(User.apply _)
  
  /**
   * Parse a User from a ResultSet
   */
  val simple = {
    get[String]("user.username") ~
    get[String]("user.password") map {
      case username~password => User(username, password)
    }
  }
  
  // -- Queries
  
  /**
   * Retrieve a User from username.
   */
  def findByEmail(username: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from User where username = {username}").on(
        'username -> username
      ).as(User.simple.singleOpt)
    }
  }
  
  /**
   * Retrieve all users.
   */
  def findAll: Seq[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from User").as(User.simple *)
    }
  }
  
  /**
   * Authenticate a User.
   */
  def authenticate(username: String, password: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
         select * from User where 
         username = {username} and password = {password}
        """
      ).on(
        'username -> username,
        'password -> password
      ).as(User.simple.singleOpt)
    }
  }
   
  /**
   * Create a User.
   */
  def create(user: User): User = {
      DB.withConnection { implicit connection =>
      SQL(
        """
          insert into User (username, password) values (
            {username}, {password}
          )
        """
      ).on(
        'username -> user.username,
        'password -> user.password
      ).executeUpdate()
      
      user
      
    }
  }
  
}

