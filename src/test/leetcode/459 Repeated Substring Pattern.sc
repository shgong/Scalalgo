/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 */

// abcdefg
// 10000

// BAD SOLUTION
// any potential pattern must start from beginning, divisor of length
// don't need to check non-primes (cut into 2 not working, then 6 definitely not

// GOOD ONE

def repeatedSubstringPattern(s: String): Boolean = {
  // find S in S+S
  (s+s).drop(1).dropRight(1) contains s
}
