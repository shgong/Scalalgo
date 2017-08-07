package ch2.dynamic

/*
  n kinds of item, each a_i
  how many ways to choose m items, find that mod M

  n = 3
  m = 3
  a = [1,2,3]
  M = 100000

  6
  0+0+3, 0+1+2, 0+2+1, 1+0+2, 1+1+1, 1+2+0
*/

object MultiCombination {

  /*
   handle one item at once to prevent duplicates
   dp[i+1][j] = pick j from first i items
              = pick j-k from i-1 and k from a_i   => O(n m^2)
              = Sum (0 to min(j,a_i)) dp[i][j-k]
              = Sum (0 to min(j-1,a_i) dp[i][j-1-k] + dp[i][j] - dp[i][j-1-a_i]
  transform
  dp[i+1][j] = dp[i+1][j-1] + dp[i][j] - dp[i][j-1-a_i]
  */

  def solve(n: Int, m: Int, a: Array[Int], M: Int) = {
    val dp = Array.fill(n + 1)(Array.fill(m + 1)(0))

    for (i <- 0 to n) dp(i)(0) = 1

    for (i <- 1 until n; j <- 1 to m) {
      if (j - 1 - a(i) >= 0)
        dp(i + 1)(j) = (dp(i + 1)(j - 1) + dp(i)(j) - dp(i)(j - 1 - a(i)) + M) % M // in case negative
      else
        dp(i + 1)(j) = (dp(i + 1)(j - 1) + dp(i)(j)) % M
    }

    println(dp(n)(m))
  }
}
