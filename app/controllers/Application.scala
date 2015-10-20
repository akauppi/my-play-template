package controllers

import models.User
import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    val users = User.listAll()
    val user = User.find(1)

    Ok(views.html.index(users, user))
  }

}
