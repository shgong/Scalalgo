// if the array has a continuous subarray of size at least 2 that sums up to the multiple of k


def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
  // non-negative => check mod, special case 0
  // delay a turn to insert (2 elements size)
  val s = collection.mutable.Set[Int]()
  var sum = 0
  var toAdd = 0
  for(i<-nums){
    sum = if(k!=0) (sum + i) % k else sum+i
    if(s.contains(sum)) return true
    else {
      s += toAdd
      toAdd = sum
    }
  }

  false
}

checkSubarraySum(Array(23, 2, 6, 4, 7), 6)