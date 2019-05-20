package sandbox.chapter4

trait AMonad[F[_]] {
  def pure[A](a: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A, B](value: F[A])(func: A => B): F[B] =
    flatMap(value)(func andThen pure)
}

object AMonadSyntax{
  implicit class AMonadOps[A, F[_]](a:F[A]) {
    def map[B](f: A => B)(implicit M: AMonad[F]): F[B] = M.map(a)(f)

    def flatMap[B](f: A => F[B])(implicit M: AMonad[F]): F[B] = M.flatMap(a)(f)
  }

  implicit class ApplicativeOps[A](a: A){
    def pure[F[_]](implicit M: AMonad[F]) : F[A] = M.pure(a)
  }
}