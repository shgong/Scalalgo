/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
How many unique path?

Valid result must have m-1 down and n-1 right
Combination problem, select m-1 from m+n-2
 */

def uniquePaths(m: Int, n: Int): Int = {
  if(m==1 || n==1) return 1
  var product = 1.0
  (1 until n).foreach { i =>
    product = product * (m-1+i) / i
  }
  product.toInt
}


uniquePaths(3,2)


// alternate way: DP
// each cell: how many way to reach here