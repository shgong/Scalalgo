/*
Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 */

def deleteAndEarn(nums: Array[Int]): Int = {
  val base = nums.groupBy(identity).mapValues(_.sum)

  var n = -1
  var cwith = 0
  var cwithout = 0

  println(base.toList.sorted)

  for ((number, sum) <- base.toList.sorted) {
    if (number == n + 1) {
      val tmp = cwith
      cwith = cwithout + sum
      cwithout = tmp max cwithout
    } else {
      cwithout = cwith max cwithout
      cwith = cwithout + sum
    }
    println(s"$number: $cwith $cwithout")
    n = number
  }

  cwith max cwithout
}


deleteAndEarn(Array(10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,4,3,8,4,10,8,8,10,6,4,4,4,9,6,9,10,7,1,5,3,4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5))