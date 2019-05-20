package sandbox.chapter4

import org.scalatest.{FunSpec, Matchers}

class MonadTest extends FunSpec with Matchers{

  describe("Id Monad"){

    import sandbox.chapter4.AMonadSyntax._
    import Id._
    import sandbox.models.Cat

    it("should have pure") {
      "Ciao!".pure[Id] shouldEqual "Ciao!"
    }

    it("should have map") {
      Cat("fluffy").pure[Id].map(c => c.name) shouldEqual "fluffy"
    }

    it("should have flatMap") {
      Cat("fluffy").pure[Id].flatMap(c => c.name.pure[Id]) shouldEqual "fluffy"
    }
  }
}
