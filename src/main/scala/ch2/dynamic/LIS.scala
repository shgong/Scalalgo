package ch2.dynamic

import scala.annotation.tailrec

// Longest increasing subsequence

object LIS {

  // solution 1
  // dp[i] = the length of LIS that ends with a_i
  // dp[i] = max { 1, dp[j]+1 if j<i & aj<ai }

  // O(n^2)
  def solve(a: Array[Int]) = {
    val dp = Array.fill(a.length)(1)
    for (i <- a.indices; j <- 0 until i if a(j) < a(i))
      dp(i) = math.max(dp(i), dp(j) + 1)
    dp.max
  }

  // solution 2
  // dp[i] = min of tail element of i+1 length LIS
  // for all j, if a_j>dp[i-1], then assign dp[i]=min(dp[i],a_j)
  //         dp is automatically sorted
  //         actually the first available is what we want, no further update needed
  // change assign order, as each a_j only assign once
  //         use binary search instead => O(nlogn)
  //         find the first i allow dp[i] smaller than current a_j, and replace it ( usually infinity )
  def solve2(a: Array[Int]) = {
    val dp = Array.fill(a.length)(Double.PositiveInfinity)
    for (i <- a.indices)
      dp(lowerBound(dp, a(i))) = a(i)
    println(dp.toList)
    dp.view.zipWithIndex.filter(!_._1.isInfinity).last._2
  }


  def lowerBound(arr: Array[Double], key: Int): Int = {
    // binary search, return first element >= key
    @tailrec
    def search(lo: Int, hi: Int): Option[Int] = {
      if (lo > hi) None
      else {
        val mid: Int = (hi + lo) / 2
        if (arr(mid) >= key) {
          if (mid == 0 || arr(mid - 1) < key) Some(mid)
          else search(lo, mid - 1)
        }
        else search(mid + 1, hi)
      }
    }
    search(0, arr.length - 1).get
  }

  def upperBound(arr: Array[Double], key: Int): Int = {
    // binary search, return first element >= key
    @tailrec
    def search(lo: Int, hi: Int): Option[Int] = {
      if (lo > hi) None
      else {
        val mid: Int = (hi + lo) / 2
        if (arr(mid) > key) {
          if (mid == 0 || arr(mid - 1) <= key) Some(mid)
          else search(lo, mid - 1)
        }
        else search(mid + 1, hi)
      }
    }
    search(0, arr.length - 1).get
  }


}
