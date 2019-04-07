package sandbox.chapter1.printable

object PrintableInstances {

  implicit val printableInt: Printable[Int] = _.toString

}
