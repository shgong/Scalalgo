// 778. Swim in Rising Water
/*
On an N x N grid, each square grid[i][j] represents the elevation at that point (i,j).

Now rain starts to fall. At time t, the depth of the water everywhere is t. You can swim from a square to another 4-directionally adjacent square if and only if the total elevation of both squares is at most t. You can swim infinite distance in zero time. Of course, you must stay within the boundaries of the grid during your swim.

You start at the top left square (0, 0). What is the least time until you can reach the bottom right square (N-1, N-1)?


00 -> N-1 N-1
 */
def swimInWater(grid: Array[Array[Int]]): Int = {
  val l = grid.length
  val visited = collection.mutable.HashSet((0, 0))
  // priority queue, always visit smallest first, set ordering
  val heap = collection.mutable.PriorityQueue((grid(0)(0), 0, 0))(Ordering.by(-_._1))

  var res = 0
  while (heap.nonEmpty) {
    val (d, x, y) = heap.dequeue()
    res = res max d // after such time haven't meet
    println(res)
    if (x == l - 1 && y == l - 1) return res

    for (
      (i, j) <- List((x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1))
      if i >= 0 && i < l && j >= 0 && j < l && !visited.contains((i, j))
    ) {
      heap.enqueue((grid(i)(j), i, j))
      visited.add((i, j))
    }
  }
  res
}

swimInWater(Array(Array(0, 2), Array(1, 3)))
val q = helper.Util.arrayArray[Int]("[[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]")
swimInWater(q)