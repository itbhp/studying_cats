package sandbox.chapter1.printable

object PrintableInstances {

  implicit val printableInt: Printable[Int] = _.toString
  implicit val printableString: Printable[String] = (a: String) => a

}
