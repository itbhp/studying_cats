package sandbox.chapter2.typeclasses

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

class BooleanMonoidsSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks{

  describe("andMonoid"){
    it("should respect the laws"){
      import sandbox.chapter2.typeclasses.BooleanMonoidInstances.andMonoid
      import sandbox.chapter2.typeclasses.MonoidLaws._

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
      import sandbox.chapter2.typeclasses.BooleanMonoidInstances.orMonoid
      import sandbox.chapter2.typeclasses.MonoidLaws._

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
      import sandbox.chapter2.typeclasses.BooleanMonoidInstances.xorMonoid
      import sandbox.chapter2.typeclasses.MonoidLaws._

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
      import sandbox.chapter2.typeclasses.BooleanMonoidInstances.xnorMonoid
      import sandbox.chapter2.typeclasses.MonoidLaws._

      forAll{
        (x: Boolean, y: Boolean, z: Boolean) => associativeLaw(x,y,z)
      }

      forAll{
        x: Boolean => identityLaw(x)
      }
    }
  }
}
