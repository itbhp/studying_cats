package sandbox.chapter1.json

trait JsonWriter[A] {
  def write(value: A): Json
}