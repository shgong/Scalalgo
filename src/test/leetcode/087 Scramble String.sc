// tree swap, for any tree partition, swapped part is scramble

def isScramble(s1: String, s2: String): Boolean = {
  if (s1 == s2) return true
  if (s1.sorted != s2.sorted) return false

  val len = s1.length

  for (i <- 1 until len) {
    if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
      isScramble(s1.substring(i), s2.substring(i))) return true
    if (isScramble(s1.substring(0, i), s2.substring(len - i)) &&
      isScramble(s1.substring(i), s2.substring(0, len - i))) return true
  }
  false
}

isScramble("great", "rgtae")
isScramble("great", "retga")