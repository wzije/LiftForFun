package org.jee.lift.snippet

import net.liftweb.http.{SHtml, S}
import net.liftweb.util.Helpers._

/**
 * @author Jehan Afwazi Ahmad.
 */

object PostSnippet {
  def render = {
    var name = ""
    var age = 0

    // process the form
    def process() {
      // if the age is < 13, display an error
      if (age < 13) S.error("Too young!")
      else {
        // otherwise give the user feedback and
        // redirect to the home page
        S.notice("Name: " + name)
        S.notice("Age: " + age)
        S.redirectTo("/")
      }
    }


    // associate each of the form elements
    // with a function... behavior to perform when the
    // for element is submitted
    "name=name" #> SHtml.onSubmit(name = _) & // set the name
      // set the age variable if we can convert to an Int
      "name=age" #> SHtml.onSubmit(s => asInt(s).foreach(age = _)) &
      // when the form is submitted, process the variable
      "type=submit" #> SHtml.onSubmitUnit(process)


  }


}
