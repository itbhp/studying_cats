package sandbox.chapter1.printable

import org.scalatest.{FunSpec, Matchers}
import sandbox.models.Cat

class PrintableSyntaxTest extends FunSpec with Matchers {

  describe("Printable type class and type class format interface") {

    it("should find how to transform cat to string") {
      import PrintableSyntax._
      Cat("fluffy").format() shouldEqual "fluffy"
    }

  }
}
