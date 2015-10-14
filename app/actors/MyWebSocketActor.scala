package actors

import akka.actor.{Props, ActorRef, Actor}
import play.Logger


object MyWebSocketActor {
  def props(out: ActorRef) = Props(new MyWebSocketActor(out))
}

class MyWebSocketActor(out: ActorRef) extends Actor {
  def receive = {
    case msg: String =>

      Logger.info("Message Received" + msg)

      out ! ("I received your message: " + msg)
  }
}
