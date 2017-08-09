package ch3.gcj

object NumberSets {

  /*
  Given [A,B] and integer P
  Initially, each number within [A,B] belong to a set contain itself
  For each number pair, merge their set if they have common prime factor >= P
   */

  val prime = Array(2, 3, 5, 7, 11, 13, 17)

  def solve(A: Int, B: Int, P: Int): Int = {
    // need a ufs with information of common prime factor
    val ufs = new UnionFindSet(B - A + 1)
    // fast, based on prime smaller than B, avoid solve common prime factor
    for (p <- prime if p >= P) {
      val start = (A + p - 1) / p * p
      val end = B / p * p
      for (x <- start + p to end by p) ufs.unite(start - A, x - A)
    }
    // println(ufs.parent.toList)
    (A to B).count(x => ufs.find(x-A) == x-A)
  }


  class UnionFindSet(N: Int) {
    val parent = Array.range(0, N)
    val rank = Array.fill(N)(0)

    def find(x: Int): Int =
      if (parent(x) == x) x
      else {
        val t = find(parent(x))
        parent(x) = t
        t
      }

    def unite(x: Int, y: Int): Unit = {
      val px = find(x)
      val py = find(y)
      if (px != py) {
        if (rank(px) < rank(py)) parent(px) = py
        else {
          parent(py) = px
          if (rank(px) == rank(py)) rank(px) += 1
        }
      }
    }

    def same(x: Int, y: Int) = find(x) == find(y)
  }


  def main(args: Array[String]): Unit = {

    val testCases = List(
      solve(10, 20, 5)
      // 10 15 20 for one set, rest for 8 sets, total 9
    )

    testCases.foreach(println)
  }
}
