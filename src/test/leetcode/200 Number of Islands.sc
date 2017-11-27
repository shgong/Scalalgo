// 1 land
// 0 water

// UFS

// Sink the lands
def numIslands(grid: Array[Array[Char]]): Int = {
  val h = grid.length
  if(h==0) return 0
  val w = grid.head.length
  if(w==0) return 0

  def sink(i: Int, j: Int): Int = {
    if (i >= 0 && i < h && j >= 0 && j < w && grid(i)(j) == '1') {
      grid(i)(j) = '0'
      sink(i + 1, j)
      sink(i - 1, j)
      sink(i, j + 1)
      sink(i, j - 1)
      1
    }
    else 0
  }

  {for(i<-0 until h;j<-0 until w) yield sink(i,j)}.sum
}

val sample =
  """11000
    |11000
    |00100
    |00011""".stripMargin

val q = sample.split('\n').map(_.toCharArray)

numIslands(q)