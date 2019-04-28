package sandbox.chapter2.cats.examples

import org.scalatest.{FunSpec, Matchers}

class SuperAdderTest extends FunSpec with Matchers {

  describe("Superadder"){
    it("should add empty list to zero"){
      SuperAdder.add(List()) shouldEqual 0
    }

    it("should add non empty list"){
      SuperAdder.add(List(1,2,3,6)) shouldEqual 12
    }
  }

}
