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

// nlogn
import scala.collection.Searching._

def maxEnvelopes2(envelopes: Array[Array[Int]]): Int = {
  val l = envelopes.length
  if(l==0) return 0

  // sort as first index up, second index down
  val sorted = envelopes.sortBy(-_(1)).sortBy(_ (0))
  val dp = collection.mutable.ArrayBuffer[Int]()

  for (env <- sorted) {
    dp.search(env(1)) match {
      case InsertionPoint(x) =>
        // extend nesting if largest, or decrease inner width
        // because sorted, won't effect previous dolls
        if(x == dp.length) dp.insert(x, env(1))
        else dp(x) = env(1)
      case Found(_) =>
    }
  }

  dp.length
}




import helper.Util._

val envs = arrayArray[Int]("[[5,4],[1,3],[6,7],[5,5],[6,4],[2,3]]")
maxEnvelopes2(envs)


