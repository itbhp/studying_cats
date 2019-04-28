package sandbox.chapter2.cats.examples

import cats.Monoid

object SuperAdder {

  def add(items: List[Int]): Int = {

    implicit val sumMonoid = new Monoid[Int] {
      override def empty: Int = 0

      override def combine(x: Int, y: Int): Int = x + y
    }

    items.fold(Monoid[Int].empty)(Monoid[Int].combine)

  }
}
