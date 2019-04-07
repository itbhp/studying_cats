package sandbox.chapter1.eq

import cats.Eq
import cats.syntax.eq._

object EqSupport {
  def compare[A](a: A, b:A)(implicit eqA: Eq[A]): Boolean = a === b
}
