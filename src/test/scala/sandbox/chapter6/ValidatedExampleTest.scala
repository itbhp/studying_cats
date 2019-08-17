package sandbox.chapter6

import cats.data.Validated
import org.scalatest.{FunSuite, Matchers}

class ValidatedExampleTest extends FunSuite with Matchers {

  import ValidatedExample._

  test("read User empty name"){
    readUser(Map("name" -> "", "age" -> "34" )) shouldEqual Validated.invalid(List("Name empty"))
  }

  test("read User without name"){
    readUser(Map("age" -> "34" )) shouldEqual Validated.invalid(List("Name not found"))
  }

  test("read User age not an int"){
    readUser(Map("name" -> "Pippo", "age" -> "boom!" )) shouldEqual Validated.invalid(List("Age not an int"))
  }

  test("read User age empty"){
    readUser(Map("name" -> "Pippo", "age" -> "" )) shouldEqual Validated.invalid(List("Age empty"))
  }

  test("read User age not present"){
    readUser(Map("name" -> "Pippo" )) shouldEqual Validated.invalid(List("Age not found"))
  }

  test("read User from nothing"){
    readUser(Map()) shouldEqual Validated.invalid(List("Name not found","Age not found"))
  }

  test("read User successfully"){
    readUser(Map("name" -> "Pippo", "age" -> "23")) shouldEqual Validated.valid(User("Pippo", 23))
  }

}
