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

    implicit val printablePerson: Printable[Person] = printableInt.contramap(_.age)

    Person("Paolo", 34).format() shouldEqual "34"
  }

  test("contramap with boxes ") {
    final case class Box[A](value: A)

    import PrintableFunctors.contravariantFunctor
    import cats.syntax.contravariant._
    import sandbox.chapter1.printable.PrintableInstances._
    import sandbox.chapter1.printable.PrintableSyntax._

    implicit def boxPrintableInstance[A](implicit printable: Printable[A]): Printable[Box[A]] =
      printable.contramap(_.value)

    Box("hello world").format() shouldEqual "hello world"
    Box(56).format() shouldEqual "56"
  }
}
