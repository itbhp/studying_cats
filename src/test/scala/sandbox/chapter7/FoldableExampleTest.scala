package sandbox.chapter7

import org.scalatest.{FunSuite, Matchers}

class FoldableExampleTest extends FunSuite with Matchers{

  import FoldableExample._

  test("map with foldRight"){
    map(List(1,2,3))(_.toString) shouldEqual List("1", "2", "3")
  }


  test("flatMap with foldRight"){
    val digits = (n: Int) => n.toString.map(_.toString).toList
    flatMap(List(12,34,56))(digits) shouldEqual List("1", "2", "3", "4", "5", "6")
  }

}
