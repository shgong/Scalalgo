// the kth maximum distinct number

// partial insertion sort
// nlogk
import collection.Searching._
def findKthLargest(nums: Array[Int], k: Int): Int = {
  val m = collection.mutable.ArrayBuffer[Int]()
  for(i<-nums){
    val id = m.search(i).insertionPoint
    m.insert(id, i)
    if(m.length>k) m.remove(0)
  }
  m(0)
}

val test = Array(1,2,3,4,5,6,7,8)
findKthLargest(test,3)