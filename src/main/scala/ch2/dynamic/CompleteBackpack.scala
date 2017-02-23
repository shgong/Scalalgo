package ch2.dynamic

// choose product with weight and value, each can choose many times
// find most value under weight limit W

object CompleteBackpack {

  def solve(w:Array[Int], v:Array[Int], W:Int) = {
    val l = w.length
    val dp = Array.fill(l)(Array.fill(l)(0))

    for (i <- l - 1 to 0; j <- 0 to W) {
      if (j < w(i)) dp(i)(j) = dp(i + 1)(j)
      else dp(i)(j) = math.max(dp(i + 1)(j), dp(i + 1)(j - w(i)) + v(i))
    }

    println(dp(0)(W))
  }

}
