package models

import anorm._
import anorm.SqlParser._
import play.api.db.DB
import play.api.Play.current

case class User(id: Int, email: String, fullname: String, isAdmin: Boolean)

object User {

  val anormParser = {
    get[Int]("id") ~
      get[String]("email") ~
      get[String]("fullname") ~
      get[Boolean]("isAdmin") map {
      case id ~ email ~ fullname ~ isAdmin => User(id, email, fullname, isAdmin)
    }
  }

  def listAll(): List[User] = DB.withConnection() { implicit connection =>
    SQL("SELECT * FROM users").as(User.anormParser.*)
  }

  def find(id: Int): Option[User] = DB.withConnection() { implicit connection =>
    SQL("SELECT * FROM users WHERE id = {id}").on("id" -> id).as(User.anormParser.singleOpt)
  }
}
