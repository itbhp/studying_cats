package sandbox.chapter2

import org.scalatest.{FunSpec, Matchers}

class BooleanMonoidSpec extends FunSpec with Matchers{

  describe("andMonoid"){
    it("should respect associativity law"){
      import MonoidLaws._
      import MonoidInstances._

      associativeLaw(true, false, true) shouldEqual false
      associativeLaw(true, true, true) shouldEqual true
    }
  }

}
