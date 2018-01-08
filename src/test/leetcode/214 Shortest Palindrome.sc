
// can only add in front
// pivot start middle, move left

def shortestPalindrome(s: String): String = {
  val l = s.length
  val mid = (l-1) / 2   // mid(left) of a 0-indexed array

  for (i <- mid to 0 by -1) {  // 1 to 0
    var j = i - 1
    while (j >= 0 && s(j) == s(2 * i - j)) j -= 1
    if (j == -1) {
      val k = s.substring(i)
      return k.drop(1).reverse + k
    }

    j = i - 1
    while (j >= 0 && s(j) == s(2 * i - 1 - j)) j -= 1
    if (j == -1) {
      val k = s.substring(i)
      return k.reverse + k
    }
  }
  s.reverse + s
}

shortestPalindrome("abcd")
shortestPalindrome("aacecaaa")
