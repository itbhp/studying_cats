package sandbox.chapter1.printable

object PrintableSyntax {
  implicit class PrintableA[A](a: A)(implicit printable: Printable[A]) {
      def format(): String = printable.format(a)
  }
}
