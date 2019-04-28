package sandbox.chapter2.cats.examples

import cats.Monoid
import cats.syntax.semigroup._

object SuperAdder {

  def add[A:Monoid](items: List[A]): A =
    items.fold(Monoid[A].empty)(_ |+| _)
}
