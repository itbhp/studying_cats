package sandbox.chapter3

import org.scalatest.{FunSuite, Matchers}
import sandbox.chapter1.printable.Printable

class ContravariantFunctorTest extends FunSuite with Matchers {

  test("contramap") {
    import PrintableFunctors._
    import sandbox.chapter1.printable.PrintableInstances._

    case class Person(name: String, age: Int)

    val printableDouble: Printable[Person] = printableInt.contramap(_.age)

    printableDouble.format(Person("Paolo", 34)) shouldEqual "34"
  }
}
