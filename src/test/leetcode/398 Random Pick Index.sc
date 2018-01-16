/*
Given an array of integers with possible duplicates,
randomly output the index of a given target number

You can assume that the given target number must exist
 */

import scala.util.Random

class Solution(_nums: Array[Int]) {

  val h = collection.mutable.HashMap[Int, List[Int]]()

  for (i <- 0 until _nums.length) {
    val n = _nums(i)
    if (h.contains(n)) h(n) ::= i
    else h(n) = List(i)
  }

  def pick(target: Int): Int = {
    val r = h(target)
    r(Random.nextInt(r.length))
  }

}

var obj = new Solution(Array(1, 2, 3, 3, 3))
obj.pick(3)
obj.pick(3)
obj.pick(3)