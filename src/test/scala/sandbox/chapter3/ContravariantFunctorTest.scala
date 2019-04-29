package sandbox.chapter3

import org.scalatest.{FunSuite, Matchers}
import sandbox.chapter1.printable.Printable

class ContravariantFunctorTest extends FunSuite with Matchers {

  test("contramap") {
    import PrintableFunctors._
    import cats.syntax.contravariant._
    import sandbox.chapter1.printable.PrintableInstances._
    import sandbox.chapter1.printable.PrintableSyntax._

    case class Person(name: String, age: Int)

    implicit val printableDouble: Printable[Person] = printableInt.contramap(_.age)

    Person("Paolo", 34).format() shouldEqual "34"
  }
}
