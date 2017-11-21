package helper

import scala.reflect.ClassTag

/**
  * Created by shgong on 11/21/17.
  */
object Util {


  trait BarImpl[T] {def apply(str: String): T}
  implicit object barInt extends BarImpl[Int] {def apply(str: String) = str.toInt}
  implicit object barBoolean extends BarImpl[Boolean] {def apply(str: String) = str.nonEmpty}

  implicit class StrConvert(x: String) {
    def toT[T](implicit impl: BarImpl[T]): T = impl(x)
  }


  def listTuple[T](str: String)(implicit impl: BarImpl[T]) : List[(T, T)] =
    str.drop(2).dropRight(2).split("],\\[").map { x =>
      val Array(a, b) = x.split(",")
      (a.toT[T], b.toT[T])
    }.toList


  // Array need ClassTag
  def arrayArray[T:ClassTag](str: String)(implicit impl: BarImpl[T]) : Array[Array[T]] =
    str.drop(2).dropRight(2).split("],\\[").map(_.split(",")).map(_.map(_.toT[T]))



  def main(args: Array[String]): Unit = {
    println(listTuple[Int]("[[5,4],[6,4],[6,7],[2,3]]"))
    println(arrayArray[Int]("[[5,4],[6,4],[6,7],[2,3]]"))

  }
}
