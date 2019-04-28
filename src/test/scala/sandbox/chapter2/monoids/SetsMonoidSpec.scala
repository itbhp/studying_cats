package sandbox.chapter2.monoids

import org.scalatest.{FunSpec, Matchers}
import org.scalatest.prop.GeneratorDrivenPropertyChecks

class SetsMonoidSpec extends FunSpec with Matchers with GeneratorDrivenPropertyChecks {

  describe("union monoid") {
    it("should respect the laws") {
      import sandbox.chapter2.MonoidLaws._
      import sandbox.chapter2.SetsMonoidInstances.unionMonoid

      forAll(
        (x:Set[Int], y:Set[Int], z:Set[Int]) => associativeLaw(x,y, z)
      )
      forAll{
        x: Set[Int] => identityLaw(x)
      }
    }
  }s
}
