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

  test("with Box") {
    case class Box[A](a: A)

    implicit def boxCodec[A](implicit codec: Codec[A]): Codec[Box[A]] = codec.imap(a => Box(a), box => box.a)

    decode[Box[Double]]("123.4") shouldEqual Box(123.4)
    encode[Box[Double]](Box(123.4)) shouldEqual "123.4"

  }
}
