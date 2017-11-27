/*
Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 */

def checkPossibility(nums: Array[Int]): Boolean = {
  if (nums.length == 1) return true
  var modify = false

  for (i <- 0 until nums.length - 1) {
    if (nums(i) > nums(i + 1)) {
      if (modify) return false
      else if (i == 0 || nums(i - 1) <= nums(i + 1)) modify = true
      else if (i == nums.length - 2 || nums(i) < nums(i + 2)) modify = true
      else return false
    }
  }
  true
}

checkPossibility(Array(4, 2, 3))
checkPossibility(Array(4, 2, 1))
checkPossibility(Array(2, 3, 3, 2, 4))
checkPossibility(Array(1, 2, 4, 5, 3))