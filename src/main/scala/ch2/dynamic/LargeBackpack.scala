package ch2.dynamic

// 0/1 backpack problem
// goods with weight and value, choose weight less than W with highest value
// 1<w<10^7    1<v<100  1<n<100

object LargeBackpack {

  // O(nW) is bad when W could be 10^9
  // use value in dp instead, minimum weight for each value

  // O(n Sum(v))
  def solve(w:Array[Int], v:Array[Int], W:Int): Unit ={

    val max_v = v.sum
    val n = w.length
    val dp = Array.fill(n+1)(Array.fill(n*max_v+1)(Double.PositiveInfinity))
    dp(0) = Array.fill(n*max_v+1)(0)

    // find minimum weight each value could hold
    for (i <- 0 until n; j <- 0 to n*max_v) {
      if (j < v(i)) dp(i+1)(j) = dp(i)(j)
      else dp(i+1)(j) = math.min(dp(i)(j), dp(i)(j - v(i)) + w(i))
    }

    // get the index within required weight
    dp(n).view.zipWithIndex
      .filter(_._1<=W)
      .filter(!_._1.isInfinity)
      .last._2
  }


}
