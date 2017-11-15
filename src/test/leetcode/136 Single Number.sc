def singleNumber(nums: Array[Int]): Int = {
 nums.reduce(_ ^ _)
}

singleNumber(Array(1,1,2,2,3,3,4,4,5,5,7,9,9,11,11))