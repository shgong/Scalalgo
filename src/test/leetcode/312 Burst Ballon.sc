/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 */

def maxCoins(nums: Array[Int]): Int = {
  val n = 1 +: nums :+ 1
  val l = n.length
  val dp = Array.fill(l)(Array.fill(l)(0))
  // dp: max coins popping range [i,j]
  for {
    len <- 1 until l - 1
    left <- 1 to l - 1 - len
    right = left + len - 1
  } {
    // choose max one to pop
    dp(left)(right) = (left to right).map { k =>
      n(left - 1) * n(k) * n(right + 1) + dp(left)(k - 1) + dp(k + 1)(right)
    }.max
  }

  dp(1)(l - 2)
}

maxCoins(Array(3,1,5,8))
/*
3 1 5 8
build up dp from one coin