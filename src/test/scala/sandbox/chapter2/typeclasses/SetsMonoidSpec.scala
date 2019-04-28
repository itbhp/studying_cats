package sandbox.chapter2.typeclasses

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FunSpec, Matchers}

class SetsMonoidSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  describe("union monoid") {
    it("should respect the laws") {
      import sandbox.chapter2.typeclasses.MonoidLaws._
      import sandbox.chapter2.typeclasses.SetsMonoidInstances.unionMonoid

      forAll(
        (x:Set[Int], y:Set[Int], z:Set[Int]) => associativeLaw(x,y, z)
      )
      forAll{
        x: Set[Int] => identityLaw(x)
      }
    }
  }
}
