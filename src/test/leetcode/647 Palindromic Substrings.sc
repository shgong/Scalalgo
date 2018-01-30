/*
count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 */

def countSubstrings(s: String): Int = {
  val l = s.length
  var res = 0

  for(i<-0 until l){
    var d = 0
    while(i-d>=0 && i+d<l && s(i-d) == s(i+d)) d+=1
    res += d

    d = 0
    while(i-d>=0 && i+1+d<l && s(i-d) == s(i+1+d)) d+=1
    res += d
  }

  res
}

countSubstrings("abc")
countSubstrings("aaa")
