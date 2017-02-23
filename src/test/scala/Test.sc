import ch1._
import ch2._
import timer.Timer._

import scala.util.Random
import scala.annotation.tailrec
import scala.collection.SeqView


val W = 5
val w = Array(2, 1, 3, 2)
val v = Array(3, 2, 4, 2)

// binary search O(2^n)

// dp to reuse previous search branches
// O(nW)
def solve(w: Array[Int], v: Array[Int], W: Int) = {
  val l = w.length
  val dp = Array.fill(l+1)(Array.fill(l+1)(-1))

  def rec(i: Int, j: Int): Int = {
    if (dp(i)(j) >= 0) dp(i)(j)
    else {
      val res =
        if (i == l) 0
        else if (j < w(i)) rec(i + 1, j)
        else scala.math.max(rec(i + 1, j), rec(i + 1, j - w(i)) + v(i))

      dp(i)(j) = res
      res
    }
  }

  rec(0, l)
}
println(solve(v, w, W))

// double loop is more elegant
def solve2(w:Array[Int], v:Array[Int], W: Int)={
  val l = w.length
  val dp = Array.fill(l)(Array.fill(l)(0))

  for(
    i<-l-1 to 0;
    j<-0 to W
  ){
    if(j<w(i))dp(i)(j) = dp(i+1)(j)
    else dp(i)(j) = math.max(dp(i+1)(j), dp(i+1)(j-w(i))+v(i))
  }

  println(dp(0)(W))
}
