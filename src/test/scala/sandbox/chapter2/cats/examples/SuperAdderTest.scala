package sandbox.chapter2.cats.examples

import cats.instances.int._
import cats.instances.option._
import org.scalatest.{FunSpec, Matchers}

class SuperAdderTest extends FunSpec with Matchers {

  describe("Superadder add(items: List[Int])"){
    it("should add empty list to zero"){
      SuperAdder.add(List[Int]()) shouldEqual 0
    }

    it("should add non empty list"){
      SuperAdder.add(List(1,2,3,6)) shouldEqual 12
    }
  }

  describe("Superadder addOption(items: List[Int])"){
    it("should add empty list to zero"){
      SuperAdder.add(List[Option[Int]]()) shouldEqual None
    }

    it("should add non empty list with"){
      SuperAdder.add(List(Some(1),None,Some(3),Some(6))) shouldEqual Some(10)
    }
  }

}
