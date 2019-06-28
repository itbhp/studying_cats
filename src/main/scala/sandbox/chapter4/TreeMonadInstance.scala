package sandbox.chapter4

import cats.Monad
import sandbox.chapter3.{Branch, Leaf, Tree}

object TreeMonadInstance {

  implicit val treeMonad: Monad[Tree] = new Monad[Tree] {
    override def pure[A](x: A): Tree[A] = Leaf(x)

    override def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] = fa match {
      case Leaf(y) => f(y)
      case Branch(left, right) => Branch(flatMap(left)(f), flatMap(right)(f))
    }

    override def tailRecM[A, B](a: A)(f: A => Tree[Either[A, B]]): Tree[B] = f(a) match {
      case Leaf(Left(l)) => tailRecM(l)(f)
      case Leaf(Right(r)) => Leaf(r)
      case Branch(l, r) => Branch(
        flatMap(l) {
          case Left(z1) => tailRecM(z1)(f)
          case Right(z2) => pure(z2)
        },
        flatMap(r) {
          case Left(z1) => tailRecM(z1)(f)
          case Right(z2) => pure(z2)
        }
      )
    }
  }

}

object TreeMonadSyntax {

  implicit class TreeMonadOps[A](tree: Tree[A]) {
    def flatMap[B](f: A => Tree[B])(implicit m: Monad[Tree]): Tree[B] =
      m.flatMap(tree)(f)
  }

}
