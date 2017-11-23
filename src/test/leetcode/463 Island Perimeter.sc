def islandPerimeter(grid: Array[Array[Int]]): Int = {
  val h = grid.length
  val w = grid(0).length

  val adjacents =
    for (i <- 0 until h; j <- 0 until w if grid(i)(j) == 1)
      yield List((i - 1, j), (i + 1, j), (i, j - 1), (i, j + 1)).count {
        case (x, y) => x >= 0 && y >= 0 && x < h && y < w && grid(x)(y) == 1
      }

  adjacents.map(4 - _).sum
}

val q = Array(
  Array(0, 1, 0, 0),
  Array(1, 1, 1, 0),
  Array(0, 1, 0, 0),
  Array(1, 1, 0, 0)
)

islandPerimeter(q)


islandPerimeter(Array(Array(1),Array(0)))