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
      name <- getValue("name") (formData)
      _    <- nonEmpty("name") (name)
    } yield name


  def readAge(formData: FormData): FailFastOr[Int] =
    for {
      ageStr <- getValue("age")    (formData)
      _      <- nonEmpty("age")    (ageStr)
      age    <- parseInt("age")    (ageStr)
      _      <- nonNegative("age") (age)
    } yield age


  private def parseInt(fieldName: String) (age: String): Either[List[String], Int] = {
    Either.catchOnly[NumberFormatException](age.toInt).leftMap(_ => List(s"${fieldName.capitalize} not an int"))
  }

  private def nonEmpty(fieldName: String) (v: String) = {
    Either.right(v).ensure(List(s"${fieldName.capitalize} empty"))(!_.isEmpty)
  }

  private def nonNegative(fieldName: String) (v: Int)  = {
    Either.right(v).ensure(List(s"${fieldName.capitalize} must be non negative"))(_ > 0)
  }

  private def getValue(fieldName: String) (formData: FormData): Either[List[String], String] = {
    formData.get(fieldName)
      .toRight(List(s"${fieldName.capitalize} not found"))
  }

}
