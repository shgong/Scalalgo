package ch2.exhaustive

// check if it is possible to choose any elements from array which sum up to k

object Sum {

  // O(2^n)
  // boolean style
  def dfs(a: Array[Int], k: Int): Boolean =
    (a.isEmpty && k == 0) ||
      (a.nonEmpty &&
        (dfs(a.tail, k) || dfs(a.tail, k - a.head)))

  // pattern match style
  def dfs(a: List[Int], k: Int): Boolean = a match {
      case Nil => k==0
      case x => dfs(a.tail, k) || dfs(a.tail, k - a.head)
    }

}
