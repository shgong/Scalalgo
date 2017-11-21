// 730. Count Different Palindromic Subsequences
// number of different non-empty palindromic subsequences in S
// modulo 10^9 + 7

// subsequence, delete 0 or more from s

def countPalindromicSubsequences(s: String): Int = {

  val l = s.length
  val dp = Array.fill(l)(Array.fill(l)(0))

  for (i <- l - 1 to 0 by -1) {
    dp(i)(i) = 1

    for (j <- i+1 until l)
      if (s(i) == s(j)) dp(i)(j) = dp(i+1)(j) + dp(i)(j-1) + 1
      else dp(i)(j) = dp(i+1)(j) + dp(i)(j-1) - dp(i+1)(j-1)
  }
  dp(0)(l-1)
}

countPalindromicSubsequences("bccb")
// accb = acc + ccb - cc
// bccb = bcc + ccb - cc + (cc + 1) = bccb + ccb + 1

// What if different?
// think about sequence with border instead

val MOD = 1000000007

def sum(k:Array[Int]): Int = {
  var res = 0
  for(i<-k) res = (res+i) % MOD
  res
}

def countDifferentPalindromicSubsequences(s: String): Int = {

  val l = s.length
  val dp = Array.fill(l)(Array.fill(l)(Array.fill(4)(0)))

  for (i <- l - 1 to 0 by -1) {

    dp(i)(i)(s(i)-'a') = 1

    for (j <- i+1 until l; r<-0 to 3)
      dp(i)(j)(r) =
        if (s(i) - 'a' == r && s(j) - 'a'== r) 2 + sum(dp(i+1)(j-1))
        else (dp(i+1)(j)(r) + dp(i)(j-1)(r) - dp(i+1)(j-1)(r)) % MOD
  }
  sum(dp(0)(l-1))
}





countDifferentPalindromicSubsequences("bccb")
// not equal => the same for each char
// equal => the border case changed, consider all borders
//          sum(cc) don't overlap as have different borders
//          add both b to all previous solutions, with b and bb (+2)