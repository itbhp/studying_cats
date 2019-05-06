package sandbox.chapter3

import cats.Contravariant
import sandbox.chapter1.printable.Printable

object PrintableFunctors {

  implicit val contravariantFunctor = new Contravariant[Printable] {
    override def contramap[A, B](fa: Printable[A])(f: B => A): Printable[B] =
      (b: B) => ( f andThen fa.format)(b)
  }

}