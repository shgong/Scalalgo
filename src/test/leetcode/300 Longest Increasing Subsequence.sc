import scala.collection.Searching._

// longest increasing subsequence
// find insertion point, insert if full, otherwise update
def lengthOfLIS(nums: Array[Int]): Int = {
  val l = nums.length
  if (l == 0) return 0

  val dp = collection.mutable.ArrayBuffer[Int]()

  for (i <- nums) {
    val x = dp.search(i).insertionPoint
    if (x == dp.length) dp.insert(x, i)
    else dp(x) = i
  }

  dp.length
}

lengthOfLIS(Array(10, 9, 2, 5, 3, 7, 101, 18))