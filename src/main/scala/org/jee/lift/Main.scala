package org.jee.lift


/**
 * @author Jehan Afwazi Ahmad.
 */
object Main {

   class Person(name: String, age: Int) {

  }

  class PersonAge(person: Person) {
    def getAge = {
      println(person.age)
    }
  }

  implicit def PersonAgePrint(person: Person): PersonAge = new PersonAge(person)


  def main(args: Array[String]) {
    println("hello Lift, nice to meet you.")
    val p1 = Person("person1", 12).getAge


  }
}









