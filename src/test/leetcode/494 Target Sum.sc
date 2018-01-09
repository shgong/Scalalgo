def findTargetSumWays(nums: Array[Int], S: Int): Int = {
  var m = Map[Int, Int](0 -> 1)
  for (num <- nums) {
    val m1 = m.map(x => (x._1 + num, x._2))
    val m2 = m.map(x => (x._1 - num, x._2))
    m = m1 ++ m2.map { case (k, v) => (k, m1.getOrElse(k, 0) + v) } // merge map
  }
  m.getOrElse(S, 0)
}

findTargetSumWays(Array(1, 1, 1, 1, 1), 3)