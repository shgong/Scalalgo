/*
In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 */

def canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {

  // total states
  val m = Array.fill(1 << 20)(0)

  // dfs with memorization
  def dfs(T: Int, k: Int): Boolean = {
    if (T <= 0 || m(k) != 0) return T > 0 && m(k) > 0
    for (i <- 0 until maxChoosableInteger) {
      // if i is not picked, and opponent can not win
      if ((k & (1 << i)) == 0 && !dfs(T - i - 1, k | (1 << i))) {
        m(k) = 1
        return true
      }
    }

    m(k) = -1
    false
  }

  val sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2
  if (sum < desiredTotal) false
  else if (desiredTotal < 2) true
  else dfs(desiredTotal, 0)
}


canIWin(10, 11)
canIWin(4, 6)