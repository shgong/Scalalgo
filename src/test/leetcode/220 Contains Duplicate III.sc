/*
value <= t
index <= k
 */

def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
  val q = collection.mutable.Queue[Int]()
  for(n<-nums){
    // toLong -> overflow
    if(q.exists(x=> math.abs(x-n.toLong)<=t)) return true
    q.enqueue(n)
    if(q.length>k) q.dequeue()
  }
  false
}
