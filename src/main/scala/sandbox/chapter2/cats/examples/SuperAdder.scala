package sandbox.chapter2.cats.examples

import cats.Monoid
import cats.instances.option._
import cats.syntax.semigroup._

object SuperAdder {

  implicit val sumMonoid = new Monoid[Int] {
    override def empty: Int = 0

    override def combine(x: Int, y: Int): Int = x + y
  }

  def add(items: List[Int]): Int =
    items.fold(Monoid[Int].empty)(Monoid[Int].combine)


  def addOption(items: List[Option[Int]]): Option[Int] =
    items.fold(Monoid[Option[Int]].empty)(_ |+| _)
}
