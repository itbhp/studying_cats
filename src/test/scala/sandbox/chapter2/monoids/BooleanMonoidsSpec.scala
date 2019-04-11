package sandbox.chapter2.monoids

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}
import sandbox.chapter2.{BooleanMonoidInstances, MonoidLaws}

class BooleanMonoidsSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks{

  describe("andMonoid"){
    it("should respect the laws"){
      import BooleanMonoidInstances.andMonoid
      import MonoidLaws._

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }

      forAll{
        x: Boolean => identityLaw(x)
      }
    }
  }

  describe("orMonoid"){
    it("should respect the laws"){
      import BooleanMonoidInstances.orMonoid
      import MonoidLaws._

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }

      forAll{
        x: Boolean => identityLaw(x)
      }
    }
  }

  describe("xorMonoid"){
    it("should respect the laws"){
      import BooleanMonoidInstances.xorMonoid
      import MonoidLaws._

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }

      forAll{
        x: Boolean => identityLaw(x)
      }
    }
  }

  describe("xnorMonoid"){
    it("should respect the laws"){
      import BooleanMonoidInstances.xnorMonoid
      import MonoidLaws._

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }

      forAll{
        x: Boolean => identityLaw(x)
      }
    }
  }
}
