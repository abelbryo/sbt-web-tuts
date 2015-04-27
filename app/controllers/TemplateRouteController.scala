package controllers

import play.api._
import play.api.mvc._


// import play.twirl.api.Html

object TemplateRouteController extends Controller {

    def home = Action { implicit request =>
        Ok(views.html.templates.home())
    }

    def about = Action { implicit request =>
        Ok(views.html.templates.about())
    }

}
