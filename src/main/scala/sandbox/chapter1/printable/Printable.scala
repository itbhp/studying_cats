package sandbox.chapter1.printable

trait Printable[A] {
  def format(a: A): String
}
