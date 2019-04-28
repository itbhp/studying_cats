package sandbox.chapter2.cats.examples

import org.scalatest.{FunSpec, Matchers}

class SuperAdderTest extends FunSpec with Matchers {

  describe("Superadder add(items: List[Int])"){
    it("should add empty list to zero"){
      SuperAdder.add(List()) shouldEqual 0
    }

    it("should add non empty list"){
      SuperAdder.add(List(1,2,3,6)) shouldEqual 12
    }
  }

  describe("Superadder addOption(items: List[Int])"){
    it("should add empty list to zero"){
      SuperAdder.addOption(List()) shouldEqual None
    }

    it("should add non empty list with"){
      SuperAdder.addOption(List(Some(1),None,Some(3),Some(6))) shouldEqual Some(10)
    }
  }

}
