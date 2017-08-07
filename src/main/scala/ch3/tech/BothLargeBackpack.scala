package ch3.tech

/* Backpack problem with large W,V, but rather small n=40
   Find within W to maximize V
   DP solution: O(nW) or O(nV)
 */

object BothLargeBackpack {

  val w = Array(2, 1, 3, 2)
  val v = Array(3, 2, 4, 2)
  val W = 5

  // possible to cut in halves 20+20
  // solve first part: w1 v1, and maximize v2 when w2<=W-w1
  // sort w2 v2 to apply binary search O(n*2^(n/2))

  def solve(w: Array[Int], v: Array[Int], W: Int) = {
    val n = w.length
    val num = n / 2

    // combination integer
    val pairs = (0 until 1 << num).map { i =>
      val ids = (0 until num).filter(j => (i >> j & 1) > 0)
      (ids.map(w).sum, ids.map(v).sum)
    }
    // keep largest value for each weight
    val p = pairs.groupBy(_._1).toList.sortBy(_._1).map(_._2.sortBy(_._2).head)

    var res = 0

    // iterator through latter part
    for (i <- 0 until 1 << (n - num)) {
      val ids = (0 until (n - num)).filter(j => (i >> j & 1) > 0).map(_ + num)
      val sw = ids.map(w).sum
      val sv = ids.map(v).sum

      if (sw <= W) {
        val tv = p(lowerBound(p, W - sw))._2
        res = math.max(res, sv + tv)
      }
    }

    res
  }

  def lowerBound(a: List[(Int, Int)], k: Int) = {
    var (lo, hi) = (-1, a.length - 1)
    while (hi - lo > 1) {
      val mid = (lo + hi) / 2
      if (a(mid)._1 >= k) hi = mid
      else lo = mid
    }
    hi
  }


}
