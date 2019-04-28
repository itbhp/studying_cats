package sandbox.chapter3

import cats.Functor
import org.scalatest.{FunSuite, Matchers}

class TreeFunctorTest extends FunSuite with Matchers {

  implicit def treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A,B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Leaf(v) => Leaf(f(v))
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
    }
  }

  test("map should work") {
    val source = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))
    val expected = Branch(Branch(Leaf(2), Leaf(4)), Leaf(6))

    Functor[Tree].map(source)(_ * 2) shouldEqual expected
  }
}
