/*
 check if s is subsequence of t.
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

// follow-up: index each characters of t to accelerate search

isSubsequence("b","c")
isSubsequence("","c")
isSubsequence("b","")
isSubsequence("bbb","bbbb")