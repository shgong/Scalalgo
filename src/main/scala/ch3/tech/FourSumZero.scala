package ch3.tech

// given 4 array, choose one from each to sum 0
// find how many combinations
// same number in one array should be treated as different combinations

object FourSumZero {

  val A = Array(-45, -41, -36, -36, 26, -32)
  val B = Array(22, -27, 53, 30, -38, -54)
  val C = Array(42, 56, -37, -75, -10, -6)
  val D = Array(-16, 30, 77, -46, 62, 45)

  // O(n^4) cut in halves from both end => O(n^2 logn)
  def solve(A: Array[Int], B: Array[Int], C: Array[Int], D: Array[Int]) = {
    val CD = C.flatMap(c => D.map(c + _)) // CD(n*i+j) = C(i) + D(j)
    A.flatMap(a => B.map(b => CD.count(_ == -a - b))).sum
  }
}
