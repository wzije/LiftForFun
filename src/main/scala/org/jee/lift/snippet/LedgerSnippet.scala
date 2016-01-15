package org.jee.lift.snippet

import net.liftweb.http.{S, SHtml}
import net.liftweb.util.Helpers._

import scala.xml._

/**
 * @author Jehan Afwazi Ahmad.
 */


object LedgerSnippet {

  def add(xhtml: NodeSeq): NodeSeq = {
    var desc = ""
    var amount = "0"

    def processEntryAdd(): Unit = {
      S.notice("description", desc)
      S.notice("amount", amount)
      S.redirectTo("/ledger")
    }

    bind("entry", xhtml,
      "description" -> SHtml.text(desc, desc = _),
      "amount" -> SHtml.text(amount, amount = _),
      "submit" -> SHtml.submit("Add", processEntryAdd))
  }

}
