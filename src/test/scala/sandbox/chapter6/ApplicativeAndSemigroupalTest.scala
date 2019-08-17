package sandbox.chapter6

import org.scalatest.{FunSuite, Matchers}

class ApplicativeAndSemigroupalTest extends FunSuite with Matchers{

  test("cat monoid"){
    import ApplicativeAndSemigroupal._

    val fluffy = Cat("fluffy", 2009, List("fish", "chips"))
    val flurry = Cat("flurry", 2018, List("cheese"))

    catMonoid.combine(fluffy, flurry) shouldBe Cat("fluffyflurry", 4027, List("fish", "chips", "cheese"))
  }

}
