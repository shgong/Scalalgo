// find longest increasing subsequence


// n^2 search
def maxEnvelopes(envelopes: Array[Array[Int]]): Int = {
  val l = envelopes.length
  if(l==0) return 0
  val sorted = envelopes.sortBy(_ (1))
  val dp = Array.fill(l)(0)


  for (i <- 0 until l) {
    dp(i) = 1
    for (j <- 0 until i) {
      if (sorted(j)(0) < sorted(i)(0) && sorted(j)(1) < sorted(i)(1))
        dp(i) = dp(i) max (dp(j) + 1)
    }
  }
  dp.max
}




import helper.Util._

val envs = arrayArray[Int]("[[5,4],[1,3],[6,7],[6,4],[2,3]]")
maxEnvelopes(envs)

import scala.collection.Searching._

Array(1, 3, 4, 6, 12, 100).search(3)