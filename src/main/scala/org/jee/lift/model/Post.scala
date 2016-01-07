package org.jee.lift.model

import net.liftweb.mapper._

/**
 * @author Jehan Afwazi Ahmad.
 */

class Post extends LongKeyedMapper[Post] {

  def getSingleton = Post

  def primaryKeyField = id

  object id extends MappedLongIndex(this)

  object title extends MappedString(this,140)

  object content extends MappedText(this)

  object published extends MappedBoolean(this)

}

object Post extends Post with LongKeyedMetaMapper[Post]
