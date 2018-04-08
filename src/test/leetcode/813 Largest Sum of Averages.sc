// 813. Largest Sum of Averages
/*
We partition a row of numbers A
into at most K adjacent (non-empty) groups

score is the sum of the average of each group

What is the largest score we can achieve?

Note that our partition must use every number in A
and that scores are not necessarily integers.
 */

def largestSumOfAverages(A: Array[Int], K: Int): Double = {
  var maxsum = 0.0
  val sum = A.scanLeft(0)(_ + _)
  val len = A.length
  val memo = Array.fill(100)(Array.fill(100)(-1.0))

  def search(start: Int, k: Int): Double = {
    if (memo(start)(k) > 0) return memo(start)(k)

    if (k == 1) {
      val avg = (sum(len) - sum(start)) * 1.0 / (len - start)
      return avg
    }

    // k>=2 find a split [start, j]
    var result = -1.0
    for (j <- start until len - k + 1) {
      val avg = (sum(j + 1) - sum(start)) * 1.0 / (j + 1 - start)
      val rest = search(j + 1, k - 1)
      result = result max (avg + rest)
    }

    memo(start)(k) = result
    //println(s"$start $k $result")
    result
  }

  search(0, K)
}

var A = Array(9, 1, 2, 3, 9)
var K = 3
largestSumOfAverages(A, K)

largestSumOfAverages(Array(1, 2, 3, 4, 5, 6, 7), 4)