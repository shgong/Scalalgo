

//Max Increase to Keep City Skyline
/*
grid[i][j] represents the height of a building located there
can increase the height of any number of buildings, by any amount (the amounts can be different for different buildings).
Height 0 is considered to be a building as well.

At the end, the "skyline" when viewed from all four directions of the grid, i.e. top, bottom, left, and right,
must be the same as the skyline of the original grid
 */

def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
  val h = grid.length
  if(h==0) return 0
  val w = grid(0).length
  if(w==0) return 0

  val mx = Array.fill(h)(0)
  val my = Array.fill(w)(0)

  for(x<-0 until h; y<-0 until w){
    mx(x) = mx(x) max grid(x)(y)
    my(y) = my(y) max grid(x)(y)
  }

  var inc = 0

  for(x<-0 until h; y<-0 until w){
    val i =mx(x) min my(y)
    inc += i - grid(x)(y)
  }

  inc
}

val g = Array(
  Array(3,0,8,4),Array(2,4,5,7),Array(9,2,6,3),Array(0,3,1,0)
)

maxIncreaseKeepingSkyline(g)