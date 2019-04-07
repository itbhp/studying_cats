package sandbox.chapter1.printable

import org.scalatest.{FunSpec, Matchers}
import sandbox.models.Cat

class PrintableSyntaxTest extends FunSpec with Matchers {

  describe("cat to json with JsonWriter type class and type class toJson interface"){
    import PrintableSyntax._

    Cat("fluffy").format() shouldEqual "fluffy"
  }
}
