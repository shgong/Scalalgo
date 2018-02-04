// 778. Swim in Rising Water
/*
On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the total elevation of both squares is at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?


00 -> N-1 N-1
 */
def swimInWater(grid: Array[Array[Int]]): Int = {
  val l = grid.length
  var t = 0
  val visited = collection.mutable.HashSet[(Int,Int)]((0,0))

  def swim(x:Int, y:Int): Unit = {
    for(
      (i,j)<-List((x-1,y),(x+1,y),(x,y-1),(x,y+1))
      if i>=0 && i < l && j>=0 && j<l &&
        !visited.contains((i,j)) && grid(i)(j)<=t
    ) {
      visited += ((i,j))
      swim(i, j)
    }

  }

  t = grid(0)(0)

  while(true){
    for(i<-visited) swim(i._1, i._2)
    if(visited.contains((l-1,l-1))) return t

    t += 1
  }

  -1
}

swimInWater(Array(Array(0,2),Array(1,3)))