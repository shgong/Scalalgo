package ch2.dynamic

// divide n into 1~m numbers, find how many ways to divide mod M
// n = 4, m = 3
// 4 = 1+1+2 = 2+2 = 1+3 = 4

object DivideNumber {

  // use dp[i][j] to represent j divide into i
  // sum up will make 1+2+1 & 1+1+2 duplicate divisions

  // TRICKY: n/m = n/m-1 + n into exactly m parts
  // can reduce all value by 1, turns to n-m into m

  // dp[i][j] = dp[i][j-i] + dp[i-1][j]
  def solve(n:Int, m:Int, M:Int)={
    val dp = Array.fill(m+1)(Array.fill(n+1)(0))
    dp(0)(0)=1

    for (i <- 1 to n; j <- 0 to m) {
      if(i<=j) dp(i)(j) = (dp(i-1)(j) + dp(i)(j-i)) % M
      else dp(i)(j) = dp(i-1)(j)
    }

    println(dp(n)(m))
  }

}
