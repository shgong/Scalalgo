
// if all positive
def subarraySumAllPositive(nums: Array[Int], k: Int): Int = {
  val q = collection.mutable.Queue[Int]()
  var sum = 0
  var res = 0

  for (i <- nums) {
    q.enqueue(i)
    sum += i

    while (sum > k) {
      val first = q.dequeue()
      sum -= first
    }
    if (sum == k) {
      println(q.toList); res += 1
    }
  }
  res
}

// HashMap for prefix sum
// two sum

def subarraySum(nums: Array[Int], k: Int): Int = {
  val m = collection.mutable.HashMap(0 -> 1)
  var sum = 0
  var res = 0

  for (i <- nums) {
    sum += i
    if(m.contains(sum-k)) res += m(sum-k)

    if (m.contains(sum)) m(sum) += 1
    else m(sum) = 1
  }
  res
}

subarraySum(Array(1, 3, 5, 7, 8, 4, 2, 3, 1, 8), 12)