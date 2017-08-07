package ch3.dynamic

/*
Pave Bricks

Given nxm grid, painted with black or white
Cover all white but no black grid with 1x2 bricks
Find how many solutions exist (mod M for large numbers)
 */

object PaveBricks {

  val M = 10

  /*
  false: white
  true: black

  F F F
  F T F
  F F F
   */


  // Basic Solution
  def solve(color: Array[Array[Boolean]]): Int = {
    val n = color.length
    val m = color.head.length

    var crt = Array.fill(1 << m)(0)
    var next = Array.fill(1 << m)(0)
    crt(0) = 1

    // dp
    // we are filling line by line
    for {i <- n - 1 to 0 by -1
         j <- m - 1 to 0 by -1} {
      println(s"process $i $j")
      // used shows the occupied status of the next line
      for {used <- 0 until 1 << m} {

        if ((used >> j & 1) == 1 || color(i)(j)) {
          // if placed (head of used is 1) or black (color is true)
          // no placement, pass to next
          next(used) = crt(used & ~(1 << j))
        } else {
          // if not placed
          var res = 0
          // place horizon
          // check next block is available
          if (j + 1 < m && (used >> (j + 1) & 1) == 0 && !color(i)(j + 1)) {
            println(s"place horizon ${used | 1 << (j + 1)}")
            res += crt(used | 1 << (j + 1))
          }
          // place vertical
          // no need to check beneath block
          if (i + 1 < n && !color(i + 1)(j)) {
            println(s"place vertical ${used | 1 << j}")
            res += crt(used | 1 << j)
          }
          next(used) = res % M
        }
      }

      println(crt.toList)
      println(next.toList)
      // swap, next block
      var temp = crt
      crt = next
      next = temp

    }

    println(crt(0))
    0
  }

  // Optimized Pavement
  def pave(color: Array[Array[Boolean]]): Int = {
    val n = color.length
    val m = color.head.length
    val lm = 1 << m // state space 2^m

    var current = Array.fill(lm)(0)
    var next = Array.fill(lm)(0)
    current(0) = 1

    // dp, filling block by block
    // [used] shows the occupied status of the next line
    for (i <- 0 until n; j <- 0 until m) {
      for (used <- 0 until lm) {
        val shifted = (used << 1) % lm

        // if placed (head of used is 1) or black (color is true), shuffle by 1, pass to next
        if ((used >> (m-1) & 1) == 1 || color(i)(j)) next(shifted) += current(used)
        else {
          if (j + 1 < m && (used >> (m - 2) & 1) == 0 && !color(i)(j + 1)) // try place horizon, check next block
            next(shifted | 1 << (m - 1)) += current(used)
          if (i + 1 < n && !color(i + 1)(j))                               // try place vertical, no need check down
            next(shifted | 1) += current(used)
        }
      }
      current = next
      next = Array.fill(lm)(0)
    }

    println(current.toList)
    current(0)
  }

  def main(args: Array[String]): Unit = {
    val a = Array(
      Array(false, false, false),
      Array(false, true, false),
      Array(false, false, false)
    )
    println(pave(a))
  }
}
