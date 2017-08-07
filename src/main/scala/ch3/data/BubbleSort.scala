package ch3.data

/*
Use Segment Tree (from Crane problem)

Bubble sort a sequence a(0) to a(i-1)
Find how many swap is required
 */

object BubbleSort {

  /*
    swap count = (i,j) pair with a(i)>a(j) & i<j
   */
  def solve(a: Array[Int]) = {

    val n = a.length

    // Binary Indexed Tree
    // e.g. 8 node BIT
    //      0001 0010 0011 0100 0101 0110 0111 1000
    //      1    1-2  3    1-4  5    5-6  7    1-8

    val bit = Array.fill(n)(0)

    def sum(i: Int): Int = {
      var k = i
      var s = 0
      while (k > 0) {
        s += bit(k)
        k -= k & -k // same as k = k & (k-1), remove last
      }
      s
    }

    def add(i: Int, x: Int): Unit = {
      var k = i
      while (k <= n) {
        bit(k) += x
        k += k & -k // 1 => 1-2 => 1-4 => 1-8
      }
    }


    // start pair count
    var ans = 0
    a.indices.foreach { j =>
      // sum(a(j)) is the i that have i<j ai<=aj
      // remove from j, it is i<j ai>aj
      ans += j - sum(a(j))
      add(a(j), 1)

    }

  }

}
