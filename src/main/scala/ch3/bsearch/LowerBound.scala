package ch3.bsearch

import scala.annotation.tailrec

// find first a>=k in sorted array

object LowerBound {
  def solve(a:Array[Int], k:Int ) = {
    var (lo, hi) = (-1, a.length)
    while(hi - lo > 1) {
      val mid = (lo + hi)/2
      if(a(mid)>=k) hi = mid
      else lo = mid
    }
    hi
  }

  def lowerBound(arr: Array[Int], key: Int): Int = {
    // binary search, return first element >= key
    @tailrec
    def search(lo: Int, hi: Int): Int = {
      if (hi-lo <= 1) hi
      else {
        val mid: Int = (hi + lo) / 2
        if (arr(mid) >= key) search(lo, mid)
        else search(mid, hi)
      }
    }
    search(-1, arr.length)
  }

  def upperBound(arr: Array[Int], key: Int): Int = {
    // binary search, return first element >= key
    @tailrec
    def search(lo: Int, hi: Int): Int = {
      if (hi-lo <= 1) lo
      else {
        val mid: Int = (hi + lo) / 2
        if (arr(mid) > key) search(lo, mid)
        else search(mid, hi)
      }
    }
    search(-1, arr.length)
  }


}
