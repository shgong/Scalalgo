// find longest palindrome that can be built with

def longestPalindrome(s: String): Int = {
  val dict = s.groupBy(identity).mapValues(_.length)
  println(dict)

  var odd = false
  var len = 0

  dict.values.foreach{ i =>
    if((i & 1) == 0) len += i
    else {
      len += i-1
      odd = true
    }
  }

  if(odd) len+1 else len
}

longestPalindrome("abccccdd")