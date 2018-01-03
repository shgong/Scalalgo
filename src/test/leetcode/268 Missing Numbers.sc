def missingNumber(nums: Array[Int]): Int = {
  val l = nums.length
  val sum = l * (l+1) / 2
  sum - nums.sum
}