/*
In a N x N grid representing a field of cherries, each cell is one of three possible integers.

0 means the cell is empty, so you can pass through;
1 means the cell contains a cherry, that you can pick up and pass through;
-1 means the cell contains a thorn that blocks your way.
Your task is to collect maximum number of cherries possible by following the rules below:

Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.

Input: grid =
[[0, 1, -1],
 [1, 0, -1],
 [1, 1,  1]]
Output: 5
 */

def cherryPickup(grid: Array[Array[Int]]): Int = {
  val N = grid.length
  val dp = Array.fill(N)(Array.fill(N)(Array.fill(N)(Integer.MIN_VALUE)))

  // dp(i)(j)(k)  one guy go to i,j another go to k,i+j-k | i<k
  for (i <- 0 until N; j <- 0 until N; k <- 0 to i + j if k < N && i + j - k < N) {

    if (i == 0 && j == 0) {
      if (grid(i)(j) != -1) dp(i)(j)(k) = grid(i)(j)
    } else if (grid(i)(j) != -1 && grid(k)(i + j - k) != -1) {
      // dd, rd, dr, rr
      val adj = for ((x, y, z) <- List((i - 1, j, k - 1), (i, j - 1, k - 1), (i - 1, j, k), (i, j - 1, k))
                     if x >= 0 && y >= 0 && z >= 0 && x + y - z >= 0 &&
                       grid(x)(y) != -1 && grid(z)(x + y - z) != -1)
        yield dp(x)(y)(z)

      // walk together
      if (adj.nonEmpty) {
        if (i == k) dp(i)(j)(k) = adj.max + grid(i)(j)
        else dp(i)(j)(k) = adj.max + grid(i)(j) + grid(k)(i + j - k)
      }
    }
    // println(s"$i $j $k ${i + j - k} " + dp(i)(j)(k))
  }

  val res = dp(N - 1)(N - 1)(N - 1)
  if(res<0) 0 else res
}


val q = Array(
  Array(1, 1, 1),
  Array(0, 1, 0),
  Array(1, 1, 1)
)

cherryPickup(q)