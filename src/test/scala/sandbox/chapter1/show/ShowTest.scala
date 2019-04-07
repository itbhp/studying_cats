package sandbox.chapter1.show

import cats.Show
import org.scalatest.{FunSpec, Matchers}
import sandbox.models.Cat

class ShowTest extends FunSpec with Matchers {

  describe("Show type class") {

    it("should transform a known type to a string using default instances") {
      import cats.instances.int._
      catsStdShowForInt.show(3) shouldEqual "3"
    }

    it("should transform a known type to a string using default syntax") {
      import cats.instances.int._
      import cats.syntax.show._
      3.show shouldEqual "3"
    }

    it("should transform a custom type providing an implicit instance") {
      import cats.syntax.show._

      implicit val catShow: Show[Cat] = Show.show(_.name)

      Cat("fluffy").show shouldEqual "fluffy"
    }
  }

}
