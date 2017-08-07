package ch2.dynamic

// longest common subsequence
// abcd + becd => bcd

object LCS {

  def solve(s:String, t:String) = {
    val l = s.length
    val dp = Array.fill(l)(Array.fill(l)(0))

    for (i <- 0 to s.length; j <- 0 to t.length) {
      if(s(i)==t(j)) dp(i+1)(j+1) = dp(i)(j) + 1
      else dp(i+1)(j+1) = math.max(dp(i)(j+1), dp(i+1)(j))
    }

    dp(s.length)(t.length)
  }

}
