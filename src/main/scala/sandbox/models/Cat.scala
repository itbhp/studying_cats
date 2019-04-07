package sandbox.models

import cats.Eq
import sandbox.chapter1.json.{JsObject, JsString, JsonWriter}
import sandbox.chapter1.printable.Printable

case class Cat(name: String)

object Cat{
  import cats.syntax.eq._

  implicit val catJson : JsonWriter[Cat] =
    (value: Cat) => JsObject(Map("name" -> JsString(value.name)))

  implicit val catPrintable: Printable[Cat] =  _.name

  implicit def catEq(implicit eqString: Eq[String]): Eq[Cat] =
    Eq.instance[Cat]((a:Cat, b:Cat) => a.name === b.name)
}
