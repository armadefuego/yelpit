package controllers

import play.api._
import play.api.mvc._

trait Secured {

  private def username(request: RequestHeader) = request.session.get("email")

  private def onUnauthorized(request: RequestHeader) = Results.Redirect(routes.Application.index)

  /** 
   * Action for authenticated users.
   */
  def IsAuthenticated(f: => String => Request[AnyContent] => Result) = Security.Authenticated(username, onUnauthorized) { user =>
    Action(request => f(user)(request))
  }
}
