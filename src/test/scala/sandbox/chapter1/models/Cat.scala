package sandbox.chapter1.models

import sandbox.chapter1.json.{JsObject, JsString, JsonWriter}
import sandbox.chapter1.printable.Printable

case class Cat(name: String)

object Cat{
  implicit val catJson : JsonWriter[Cat] =
    (value: Cat) => JsObject(Map("name" -> JsString(value.name)))

  implicit val catPrintable: Printable[Cat] =  _.name
}
