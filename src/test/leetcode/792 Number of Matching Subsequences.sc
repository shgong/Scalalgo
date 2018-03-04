/*

Given string S and a dictionary of words words,
find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words
that are a subsequence of S: "a", "acd", "ace".
 */

def isSubsequence(s: String, t: String): Boolean = {
  var i = 0
  var j = 0
  while(i<s.length && j<t.length){
    while(j<t.length && t(j) != s(i)) j += 1
    if(j == t.length) return false
    i += 1
    j += 1
  }
  i == s.length
}

def numMatchingSubseq(S: String, words: Array[String]): Int = {
  words.count(w=> isSubsequence(w,S))
}

numMatchingSubseq("abcde", Array("a", "bb", "acd", "ace"))