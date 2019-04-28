package sandbox.chapter3

import sandbox.chapter1.printable.Printable

object PrintableFunctors {

  implicit class PrintableContravariant[A](a: Printable[A]) {
    def contramap[B](f: B => A): Printable[B] = ???
  }

}