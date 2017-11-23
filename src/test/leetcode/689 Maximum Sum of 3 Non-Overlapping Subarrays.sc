// find three non-overlapping subarrays
// maximize k size subarray sum

def maxSumOfThreeSubarrays(nums: Array[Int], k: Int): Array[Int] = {
  // k size sums
  // sliding(k).map(_.sum)
  val q = collection.mutable.Queue[Int]()
  var sum = 0
  val s = collection.mutable.ArrayBuffer[Int]()

  for(i<-nums){
    q.enqueue(i)
    sum += i
    if(q.length == k) {
      s.append(sum)
      sum -= q.dequeue()
    }
  }

  // 3 part sum, with k distance
  val len = s.length
  var max = 0
  var res:List[Int] = null

  for (i <- 0 until len - 2 * k) {
    if(res==null || s(i)>s(res(0)))
    for (j <- i + k until len - k) {
      if(res==null || s(i)+s(j)>s(res(0))+ s(res(1)))
      for (h <- j + k until len) {
        val lsum = s(i)+s(j)+s(h)
        if(lsum>max) {
          max = lsum
          res = List(i,j,h)
        }
      }
    }
  }

  res.toArray
}

maxSumOfThreeSubarrays(
  Array(1,2,1,2,6,7,5,1),
  2
)

