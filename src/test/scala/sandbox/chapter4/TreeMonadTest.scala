package sandbox.chapter4

import org.scalatest.{FunSpec, Matchers}
import sandbox.chapter3.{Branch, Leaf, Tree}

class TreeMonadTest extends FunSpec with Matchers{

  import TreeMonadInstance._

  describe("tree monad"){

    it("should have pure implemented"){
      treeMonad.pure(3) shouldBe Leaf(3)
    }

    it("should have flatMap implemented"){
      val aTree: Tree[Int] = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

      treeMonad.flatMap(aTree)(a => Leaf(a.toString)) shouldEqual Branch(Branch(Leaf("1"), Leaf("2")), Leaf("3"))
    }
  }

}
