package ch2.greedy

// cut long wood repeatly until into N pieces as desired
// cut each wood cost equal to N
// find the minimum cost

object FenceRepair {

  val l = Array(8, 5, 8)

  // find shortest 2 wood
  // O(n2), will introduce O(nlogn) later
  def solve(l: Array[Int]) = {
    var ans = 0
    var n = l.length

    while (n > 1) {
      var (m1,m2)= if (l(0) < l(1)) (0, 1) else (1, 0)

      // find top 2
      2 until n foreach { i =>
        if (l(i) < l(m1)) {m2=m1;m1=i;}
        else if (l(1) < l(m2)) m2 = i
      }

      val t = l(m1) + l(m2)
      ans += t
      if (m1 == n - 1) {val temp = m2; m2=m1; m1=temp}
      l(m1) = t
      l(m2) = l(n - 1)
      n -= 1
    }

    ans
  }
}

// this solution is also known as huffman encoding