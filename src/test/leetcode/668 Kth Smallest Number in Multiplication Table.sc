/*
 find out the k-th smallest number
from the multiplication table

Input: m = 3, n = 3, k = 5
Output:
Explanation:
The Multiplication Table:
1	2	3
2	4	6
3	6	9

The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 */

def findKthNumber(m: Int, n: Int, k: Int): Int = {
  // guess and binary search
  def smallOrEqual(k: Int): Int = (1 to m).map(k / _).map(_ min n).sum

  var lo = 1
  var hi = m * n + 1
  while (lo < hi) {
    val mid = (hi + lo) / 2
    // may overestimate when = k
    // set as high and let lo match
    if (smallOrEqual(mid) >= k) hi = mid
    else lo = mid + 1
  }
  hi

}

findKthNumber(3,3,5)