package ch3.tech

// find shortest subsequence that sum up to >= S
// S = 15
// a = 5,1,3,5,10,7,4,9,2,8 (positive sequence)

object Subsequence {

  // Solution 1:
  // Pre calculate Sum(0-n), Sm-Sn to get segment sum
  // bSearch for each starting point
  // O(nlogn)

  // Solution 2: propogate segment
  def solve(a: Array[Int], S: Int) = {
    var (s, t, sum) = (0, 0, 0)
    var res = 0

    while (t < a.length && sum < S) {
      sum += a(t)
      t += 1
    }

    while (sum >= S) {
      res = math.min(res, t-s)
      sum -= a(s)
      s += 1

      while (t < a.length && sum < S) {
        sum += a(t)
        t += 1
      }
    }

    res
  }


}
