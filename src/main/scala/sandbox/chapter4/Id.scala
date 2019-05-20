package sandbox.chapter4

object Id {
  type Id[A] = A

  implicit val idMonad: AMonad[Id] = new AMonad[Id] {
    override def pure[A](a: A): Id[A] = a

    override def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = func(value)
  }
}
