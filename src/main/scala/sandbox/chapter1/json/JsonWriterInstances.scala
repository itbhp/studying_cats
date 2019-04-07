package sandbox.chapter1.json

final case class Person(name: String, email: String)

object JsonWriterInstances {
  implicit val stringWriter: JsonWriter[String] =
    (value: String) => JsString(value)

  implicit val personWriter: JsonWriter[Person] =
    (value: Person) => JsObject(Map(
      "name" -> JsString(value.name),
      "email" -> JsString(value.email)
    ))

  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
    (option: Option[A]) => option.fold(JsNull: Json)(a => writer.write(a))
}


