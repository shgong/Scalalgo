package ch2.structure

import scala.collection.mutable


// cut long wood repeatly until into N pieces as desired
// cut each wood cost equal to N
// find the minimum cost

object FenceRepair {

  val l = Array(8, 5, 8)

  def solve(l: Array[Int]) = {
    val minHeap = mutable.PriorityQueue[Int](l:_*)(Ordering[Int].reverse)
    var ans = 0
    while(minHeap.size>1){
      val r = minHeap.dequeue() + minHeap.dequeue()
      ans += r
      minHeap.enqueue(r)
    }
    ans
  }
}
