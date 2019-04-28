package sandbox.chapter3

import cats.Functor
import cats.syntax.functor._
import org.scalatest.{FunSuite, Matchers}
import sandbox.chapter3.TreeTypeClassesInstances._

class TreeFunctorTest extends FunSuite with Matchers {

  test("map should work") {
    val source: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    val expected: Tree[Int] = Branch(Branch(Leaf(2), Leaf(4)), Leaf(6))

    Functor[Tree].map(source)(_ * 2) shouldEqual expected

    source.map(_ * 2) shouldEqual expected
  }
}

