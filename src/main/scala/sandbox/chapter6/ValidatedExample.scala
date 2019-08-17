package sandbox.chapter6

import cats.data.Validated
import cats.syntax.either._
import cats.syntax.apply._
import cats.instances.list._

import scala.util.Try

object ValidatedExample {

  case class User(name: String, age: Int)

  type FormData = Map[String, String]

  type FailFastOr[A] = Either[List[String], A]

  type FailAtTheEndOr[A] = Validated[List[String], A]

  def readUser(formData: FormData): FailAtTheEndOr[User] =
    (readName(formData).toValidated, readAge(formData).toValidated).mapN(User.apply)

  def readName(formData: FormData): FailFastOr[String] =
    formData.get("name")
      .toRight(List("Name not found"))
      .ensure(List("Name empty"))(!_.isEmpty)

  def readAge(formData: FormData): FailFastOr[Int] =
    formData.get("age")
      .toRight(List("Age not found"))
      .ensure(List("Age empty"))(!_.isEmpty)
      .flatMap(age => Either.catchOnly[NumberFormatException](age.toInt).leftMap(_ => List("Age not an int")))

}
