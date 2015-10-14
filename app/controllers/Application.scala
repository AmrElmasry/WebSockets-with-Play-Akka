package controllers


import actors.MyWebSocketActor
import play.Logger
import play.api.mvc._
import play.api.Play.current

class Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def socket = WebSocket.acceptWithActor[String, String] {

  Logger.info("WebSockets Actor Created")
   request => out =>
  MyWebSocketActor.props(out)

}
}