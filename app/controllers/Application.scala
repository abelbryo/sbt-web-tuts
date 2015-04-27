package controllers


import play.api.mvc._
import play.api.libs.iteratee._
import play.api.libs.Comet

import play.api.libs.json._

import play.api.libs.concurrent._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import java.util.Date

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def message = Action (parse.json){
    implicit request =>
        val email = request.body.\("email")
        val body = request.body.\("message")
        val result = Json.obj("email" -> email, "body" -> body)
    Ok(result).as("application/json")
  }


  // Sends out a comet message every 1 second
  def comet = Action {
      val events = Enumerator.generateM {
          Promise.timeout(Some(s"Date: ${new Date().toString()}"), 1000 milliseconds)
      }

    Ok.chunked(events.through(Comet[String](callback="parent.cometMessage")))
  }






}
