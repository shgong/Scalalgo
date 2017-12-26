//  find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

def minMoves(nums: Array[Int]): Int = {
  val min = nums.min
  nums.map(_ - min).sum
}

minMoves(Array(1,2,3))