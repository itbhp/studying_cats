package sandbox.chapter1.json

import org.scalatest.{FunSpec, Matchers}
import sandbox.models.Cat

class JsonSyntaxTest extends FunSpec with Matchers{

  describe("JsonWriter type class and type class toJson interface") {

    it("should find how to transform cat to json") {
      import JsonSyntax._

      Cat("fluffy").toJson shouldEqual JsObject(Map("name" -> JsString("fluffy")))
    }
  }
}
