/*
827. Making A Large Island

In a 2D grid of 0s and 1s, we change at most one 0 to a 1.
After, what is the size of the largest island?
 */

def largestIsland(grid: Array[Array[Int]]): Int = {

  val h = grid.length
  val w = grid(0).length

  var count = 0
  var area = 2

  // area number -> size tracker
  val m = collection.mutable.HashMap[Int, Int]()

  def sink(x: Int, y: Int): Unit = {
    if (x >= 0 && y >= 0 && x < h && y < w && grid(x)(y) == 1) {
      count += 1
      grid(x)(y) = area

      sink(x - 1, y)
      sink(x + 1, y)
      sink(x, y - 1)
      sink(x, y + 1)
    }
  }

  // traverse to mark area number
  for (i <- 0 until h; j <- 0 until w) {
    if (grid(i)(j) == 1) {
      count = 0
      sink(i, j)
      m(area) = count
      area += 1
    }
  }

  var maxArea = if (m.isEmpty) 0 else m.values.max

  // try convert each grid point
  for (i <- 0 until h; j <- 0 until w if grid(i)(j) == 0) {
    val areas = for ((x, y) <- List((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1))
                     if x >= 0 && y >= 0 && x < h &&
                       y < w && grid(x)(y) > 1)
      yield grid(x)(y)
    val newMax = areas.toSet.toList.map(m).sum + 1
    maxArea = maxArea max newMax
  }

  maxArea
}



largestIsland(
  Array(
    Array(1, 0),
    Array(0, 1)
  )
)

largestIsland(
  Array(
    Array(1, 0, 1),
    Array(0, 1, 1),
    Array(0, 1, 1)
  )
)