package sandbox.chapter2.cats.examples

import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import org.scalatest.{FunSpec, Matchers}

class SuperAdderTest extends FunSpec with Matchers {

  describe("with Int") {
    it("should add empty list to zero") {
      SuperAdder.add(List[Int]()) shouldEqual 0
    }

    it("should add non empty list") {
      SuperAdder.add(List(1, 2, 3, 6)) shouldEqual 12
    }
  }

  describe("with Option[Int]") {
    it("should add empty list to zero") {
      SuperAdder.add(List[Option[Int]]()) shouldEqual None
    }

    it("should add non empty list") {
      SuperAdder.add(List(Some(1), None, Some(3), Some(6))) shouldEqual Some(10)
    }
  }

  describe("with Order") {

    it("should add empty list to zero") {
      SuperAdder.add(List[Order]()) shouldEqual Order(0, 0)
    }

    it("should add non empty list") {
      SuperAdder.add(List(Order(3.0, 1), Order(6.2, 3))) shouldEqual Order(9.2, 4)
    }
  }

}

case class Order(totalCost: Double, quantity: Double)

object Order {
  val EMPTY = Order(0, 0)
  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    override def empty: Order = EMPTY

    override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }
}
