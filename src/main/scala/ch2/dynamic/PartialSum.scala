package ch2.dynamic

// n numbers a_i, total m_i available for each
// check if we can choose some, making the sum equal to K

object PartialSum {

  /*
  how to design dp
  dp[i+1][j] => if we can form j with first i number
                store only boolean will lose information
                O(K Sum(m))

  instead
  dp[i+1][j] => how many a_i left when we can, otherwise -1
  dp[i+1][j] = m_i    if dp[i][j]>=0  (don't use any a_i when already possible)
                -1    if j<a_i or dp[i+1][j-a_i]<=0
               dp[i+1][j-a_i]-1

  also reuse dp array in one dimension
  */
  def solve(a: Array[Int], m: Array[Int], K: Int) = {
    val n = a.length
    val dp = Array.fill(K + 1)(-1)
    dp(0) = 0

    for (i <- 0 to n; j <- 0 to K + 1) {
      if (dp(j) >= 0) dp(j) = m(i)
      else if (j < a(i) || dp(j - a(i)) <= 0) dp(j) = -1
      else dp(j) = dp(j - a(i)) - 1
    }

    dp(K)>=0
  }

}
