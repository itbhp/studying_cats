package sandbox.chapter3

import org.scalatest.{FunSuite, Matchers}

class CodecTest extends FunSuite with Matchers {

  import Codec._
  import CodecInstances._

  implicit val doubleCodec: Codec[Double] = stringCodec.imap(_.toDouble, _.toString)

  test("decode") {
    decode[Double]("123.4") shouldEqual 123.4
  }

  test("encode") {
    encode[Double](123.4) shouldEqual "123.4"
  }
}
