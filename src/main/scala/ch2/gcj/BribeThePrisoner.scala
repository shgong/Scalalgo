package ch2.gcj

// P adjacent cells with window
// release prisoner should bribe adjacent prisoners a coin until reach a empty cell
// how to release a_1 ~ a_Q with least golds

object BribeThePrisoner {

  // dynamic programming for each continuous block
  def solve(a: Array[Int], P: Int) = {
    val Q = a.length
    val A = 0 +: a :+ (P + 1)
    val dp = Array.fill(Q + 1)(Array.fill(Q + 2)(0))

    // from smallest sections, build dp up
    for (w <- 2 to Q + 1; i <- 0 to Q + 1 - w; j = i + w)
      dp(i)(j) = A(j) + 2 - A(i) +
        (i + 1 until j).map(k => dp(i)(k) + dp(k)(j)).min

    dp(0)(Q + 1)
  }
}
