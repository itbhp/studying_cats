package sandbox.chapter1.eq

import cats.Eq
import org.scalatest.{FunSpec, Matchers}
import sandbox.models.Cat

class EqTest extends FunSpec with Matchers {

  describe("Eq type class") {

    it("should compare a known type using default instances") {
      import cats.instances.int._
      val eqInt = Eq[Int]

      eqInt.eqv(2, 2) shouldEqual true
      eqInt.eqv(2, 4) shouldEqual false
    }

    // using compare because === of Eq is already defined in an object
    // TripleEqualSupport used by scala test

    it("should compare known types using default syntax") {
      import cats.instances.int._
      import EqSupport._
      compare(2, 3) shouldEqual false
    }

    it("should compare a custom type providing an implicit instance") {
      import EqSupport._
      import cats.instances.string._
      import cats.instances.option._

      val fluffy = Cat("fluffy")
      compare(fluffy, Cat("bob"))

      val someCat = Option(fluffy)
      val noCat = Option.empty[Cat]

      val optionEq = Eq[Option[Cat]]

      optionEq.eqv(someCat, noCat) shouldEqual false
    }
  }
}
