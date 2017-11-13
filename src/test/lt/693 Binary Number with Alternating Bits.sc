
def hasAlternatingBits(n: Int): Boolean = {
  val k = n ^ n/2  // should be all ones
  (k & k+1) <1
}
