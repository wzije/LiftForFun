package org.jee.lift.model

import net.liftweb.common.Logger
import net.liftweb.mapper._

/**
 * @author Jehan Afwazi Ahmad.
 */

class Event extends LongKeyedMapper[Event] with IdPK with Logger {
  override def getSingleton: Event = Event.this

  object EventName extends MappedString(this, 30) with ValidateLength {
    override def validations = valMinLen(3, "Event name must be more than 3 character...") _ :: super.validations
  }
}

object Event extends Event with LongKeyedMetaMapper[Event] {}
