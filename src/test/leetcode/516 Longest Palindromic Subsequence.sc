
def longestPalindromeSubseq(s:String):Int = {
    val l = s.length
    val dp = Array.fill(l)(Array.fill(l)(0))

    for (i <- l - 1 to 0 by -1) {
      dp(i)(i) = 1

      for (j <- i+1 until l)
        if (s(i) == s(j)) dp(i)(j) = dp(i+1)(j-1) + 2
        else dp(i)(j) = Math.max(dp(i+1)(j), dp(i)(j-1))
    }
    dp(0)(l-1)
}

longestPalindromeSubseq("helloolleh")