package ch3.bsearch

// N cottages in a line with position x_i
// M cows will attack each other if too close
// How to maximize minimum distance

object AggressiveCows {

  def solve(x: Array[Int], M: Int): Int = {

    val N = x.length
    val X = x.sorted

    // if it is possible to place all cows >= d
    // simple greedy problem, like Saruman Army
    def pass(d: Int): Boolean = {
      var last = 0
      for (i <- 1 until M) {
        var crt = last + 1
        while (crt < N && X(crt) - X(last) < d) {
          crt += 1
        }
        if (crt == N) false
        last = crt
      }
      true
    }


    var (lo, hi) = (0, Int.MaxValue)
    while (hi - lo > 1) {
      val mid = (lo + hi) / 2
      if (pass(mid)) lo = mid else hi = mid
    }
    lo
  }


}
