package ch3.tech

/*
flip tile will also flip adjacent
make all grid white

1 0 0 1
0 1 1 0
0 1 1 0
1 0 0 1
 */

object LightsOut {
  val directions = Array((-1, 0), (0, -1), (0, 0), (1, 0), (0, 1))
  val k = Array(Array(1, 0, 0, 1), Array(0, 1, 1, 0), Array(0, 1, 1, 0), Array(1, 0, 0, 1))
  val M = k.length
  val N = k.head.length

  // basic solution space is O(2^NM)
  // settle flip method for each row O(MN2^N)
  def solve(k: Array[Array[Int]]) = {
    var solution = Array.fill(4)(Array.fill(4)(0))
    var temp = Array.fill(4)(Array.fill(4)(0))

    // get if a position need flip
    def get(x: Int, y: Int) = {
      var c = k(x)(y)
      for ((dx, dy) <- directions; x2 = x + dx; y2 = y + dy
           if 0 <= x2 && x2 < M && 0 <= y2 && y2 < N)
        c += temp(x2)(y2)
      c % 2
    }

    // find solutions if first row is given
    def calc(): Int = {
      for (i <- 1 until M; j <- 0 until N if get(i - 1, j) != 0) temp(i)(j) = 1
      for (j <- 0 until N if get(M - 1, j) != 0) return -1
      temp.map(_.sum).sum
    }

    // brute force first row with dictionary order
    var res = -1
    for (i <- 0 until 1 << N) {
      temp = Array.fill(4)(Array.fill(4)(0))
      for (j <- 0 until N) temp(0)(N - j - 1) = i >> j & 1
      val num = calc()
      if (num >= 0 && (res < 0 || res > num)) {
        res = num
        solution = temp
      }
    }
    if (res < 0) println("impossible\n")
    else solution.foreach(a => println(a.mkString(",")))

  }
}
