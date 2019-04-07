package sandbox.chapter1.printable

object PrintableSyntax {
  implicit class PrintableA[A](a: A){
      def format()(implicit printable: Printable[A]) : String = printable.format(a)
  }
}
