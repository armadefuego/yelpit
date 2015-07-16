package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Yelpit!"))
  }

  def users = Action {
        BadRequest(Json.obj("status" ->"KO", "message" -> "WTF?"))
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
