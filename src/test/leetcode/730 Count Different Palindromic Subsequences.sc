// 730. Count Different Palindromic Subsequences
// number of different non-empty palindromic subsequences in S
// modulo 10^9 + 7

// subsequence, delete 0 or more from s

def countPalindromicSubsequences(S: String): Int = {

  def count(i:Int, j:Int):Int = {
    if(i==j) return 1
    else if(S(i)==S(j))
  }
}

countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba")
