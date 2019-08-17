package sandbox.chapter7

import cats.Monoid

object FoldableExample {

  def map[A, B](xs: List[A])(f:A => B) : List[B] =
    xs.foldRight(List.empty[B])((elem, acc) => f(elem) :: acc)

  def flatMap[A, B](xs: List[A])(f:A => List[B]) : List[B] =
    xs.foldRight(List.empty[B])((elem, acc) => f(elem) ++ acc)

  def sumWithMonoid[A: Monoid](xs: List[A]) : A =
    xs.foldRight(Monoid[A].empty)(Monoid[A].combine)
}
