package org.jee.lift.snippet

import net.liftweb.common.Full
import net.liftweb.http.js.JE._
import net.liftweb.http.js.JsCmds._
import net.liftweb.http.{SHtml, S}
import net.liftweb.util.PassThru
import net.liftweb.util.Helpers._

/**
 * @author Jehan Afwazi Ahmad.
 */


class Person(val firstName: String, val lastName: String) {
  def fullName(): String =
    s"$firstName $lastName"
}

object PlainSnippet {
  var s = S.param("name")

  def render = s match {
    case Full(name) =>
      S.notice("Hello " + name)
      S.redirectTo("/plain")
    case _ =>
      PassThru
  }


  val personMap = Map(
    10 -> new Person("Roger", "Moore"),
    20 -> new Person("James", "Bond")
  )
  val names = for {
    (key, person) <- personMap
    if key > 15
  } yield s"$key = ${person.firstName}"

  def renderButton = "button [onClick]" #> SHtml.ajaxInvoke(() => JsRaw(
    """
      |$('#ponyDiv').show()
    """.stripMargin))

  def renderButton1 = personMap
}
