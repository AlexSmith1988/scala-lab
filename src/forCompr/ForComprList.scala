package forCompr

/*
created by Ilya Volynin at 31.01.18
*/
object ForComprList {
  def main(args: Array[String]): Unit = {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)
    val motherKid = for (p <- persons; if !p.isMale; c <- p.children)
      yield (p.name, c.name)
    println(motherKid)
    val motherKid2 = for {
      p <- persons //if false
      c <- p.children
    } yield (p.name, c.name)
    println(motherKid2)
  }
}
case class Person(name: String, isMale: Boolean, children: Person*)
