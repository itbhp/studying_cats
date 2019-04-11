package sandbox.chapter2

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

class BooleanMonoidSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks{

  describe("andMonoid"){
    it("should respect the laws"){
      import MonoidLaws._
      import MonoidInstances.andMonoid

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }
    }
  }

  describe("orMonoid"){
    it("should respect the laws"){
      import MonoidLaws._
      import MonoidInstances.orMonoid

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }
    }
  }
}
