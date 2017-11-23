
def numSubarrayProductLessThanK(nums: Array[Int], k: Int): Int = {
  val q = collection.mutable.Queue[Int]()
  var product = 1
  var res = 0

  for (i <- nums) {
    q.enqueue(i)
    product *= i

    while (product >= k && q.nonEmpty) {
      val first = q.dequeue()
      product /= first
    }
    // add combinations including latest element
    if (product < k) res += q.length
  }
  res
}

numSubarrayProductLessThanK(Array(10,5,2,6), 100)