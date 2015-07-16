package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import models._

class Application extends Controller with Secured {

  implicit val rds = (
    (__ \ 'id).read[Long] and
    (__ \ 'user).read[User] and
    (__ \ 'reviews).read[String]
  ) tupled

  def index = Action {
    Ok(views.html.index())
  }

  def register = Action {
  	Ok(views.html.register())
  }

  def users = Action(parse.json) { request =>
    request.body.validate[( Long, User, String )].map{
        case ( id, user, reviews) =>
          Ok(Json.obj("id" -> id, "username" -> user.username, "password" -> user.password, "reviews" -> "[]"))
      }.recoverTotal{
        e => BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
      }
  }

  def userssave(id: Long) = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }

  def usersget(id: Long) = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }

  def authenticate = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }

  def directions = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }

  def subjects(id: Long) = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }

  def subjectsave(id: Long, subjectid: Long) = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }


  def recommend(id: Long) = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
  }
}
