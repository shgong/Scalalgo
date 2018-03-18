/*
We have a grid of 1s and 0s; the 1s in a cell represent bricks.  A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.

We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j), the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

Return an array representing the number of bricks that will drop after each erasure in sequence.
 */

def hitBricks(grid: Array[Array[Int]], hits: Array[Array[Int]]): Array[Int] = {
  val n = grid.length
  val m = grid(0).length
  val t = hits.length

  // grid  0 - nothing
  //       1 - brick
  //       -1 - connect with ceiling

  def dfs(x: Int, y: Int): Int = {
    if (x < 0 || x >= n || y < 0 || y >= m || grid(x)(y) != 1) return 0
    grid(x)(y) = -1
    1 + dfs(x, y - 1) + dfs(x, y + 1) + dfs(x - 1, y) + dfs(x + 1, y)
  }

  def connected(x: Int, y: Int): Boolean =
    x >= 0 && x < n && y >= 0 && y < m && grid(x)(y) == -1

  // first remove brick from all hits
  val bo = hits.map { case Array(x, y) =>
    val exist = grid(x)(y) == 1
    grid(x)(y) = 0
    exist
  }

  // mark the bricks connected with ceiling
  for (j <- 0 until m if grid(0)(j) == 1) dfs(0, j)

  // traverse from last hit
  val ans = Array.fill(t)(0)
  for (k <- t - 1 to 0 by -1 if bo(k)) {
    val Array(x, y) = hits(k)
    grid(x)(y) = 1

    // if ceiling or connected with ceiling, dfs
    if (connected(x, y - 1) || connected(x, y + 1) ||
      connected(x - 1, y) || connected(x + 1, y) || x == 0
    ) ans(k) = dfs(x, y) - 1
  }
  ans
}

var grid = Array(Array(1, 0, 0, 0), Array(1, 1, 1, 0))
var hits = Array(Array(1, 0))
hitBricks(grid, hits)