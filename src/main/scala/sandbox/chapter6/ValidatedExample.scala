package sandbox.chapter6

import cats.data.Validated
import cats.syntax.either._
import cats.syntax.apply._
import cats.instances.list._

object ValidatedExample {

  case class User(name: String, age: Int)

  type FormData = Map[String, String]

  type FailFastOr[A] = Either[List[String], A]

  type FailAtTheEndOr[A] = Validated[List[String], A]

  def readUser(formData: FormData): FailAtTheEndOr[User] =
    (readName(formData).toValidated, readAge(formData).toValidated).mapN(User.apply)

  def readName(formData: FormData): FailFastOr[String] =
    for{
      name <- getValue(formData, "name")
      _    <- nonEmpty(name, "name")
    } yield name


  def readAge(formData: FormData): FailFastOr[Int] =
    for {
      ageStr <- getValue(formData, "age")
      _      <- nonEmpty(ageStr, "age")
      age    <- parseInt(ageStr, "Age not an int")
    } yield age


  private def parseInt(age: String, errorMessage: String): Either[List[String], Int] = {
    Either.catchOnly[NumberFormatException](age.toInt).leftMap(_ => List(errorMessage))
  }

  private def nonEmpty(v: String, fieldName: String) = {
    Either.right(v).ensure(List(s"${fieldName.capitalize} empty"))(!_.isEmpty)
  }

  private def getValue(formData: FormData, fieldName: String): Either[List[String], String] = {
    formData.get(fieldName)
      .toRight(List(s"${fieldName.capitalize} not found"))
  }

}
