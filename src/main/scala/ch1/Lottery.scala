package ch1
import scala.annotation.tailrec

// draw with replacement, check if there exists 4 draws that sum up to m
object Lottery {
  // naive O(n4)

  // change inner cycle to binary Search
  // O(nlogn + n3logn)
  def replaceSearch(m: Int, a: Array[Int]): Boolean = {
    val n = a.length

    val searchArr = a.sorted

    // arr.view to make it lazy
    val view = for (
      i <- (0 until n).view;
      j <- (i until n).view;
      k <- (j until n).view;
      r = m - a(i) - a(j) - a(k) if bSearch(r,searchArr).isDefined
    ) yield r

    view.nonEmpty
  }

  // change inner 2 cycle to binary Search
  // O(n2logn + n2logn) = O(n2logn)
  def replaceTwoSearch(m: Int, a: Array[Int]): Boolean = {
    val n = a.length

    // generate pair sum, not lazy
    val pairSum = for(
      i <- 0 until n;
      j <- i until n
    ) yield a(i) + a(j)
    val searchArr: Array[Int] = pairSum.distinct.toArray.sorted

    // find first available, lazy
    val view = for (
      i <- (0 until n).view;
      j <- (i until n).view;
      r = m - a(i) - a(j) if bSearch(r,searchArr).isDefined
    ) yield r

    view.nonEmpty
  }


  def bSearch(key:Int, arr:Array[Int]): Option[Int]= {
    @tailrec
    def search(lo: Int, hi: Int): Option[Int] = {
      if (lo > hi) None
      else {
        val mid: Int = (hi + lo) / 2
        arr(mid) match {
          case x if x == key => Some(mid)
          case x if x <= key => search(mid + 1, hi)
          case _ => search(lo, mid - 1)
        }
      }
    }
    search(0, arr.length - 1)
  }

}
