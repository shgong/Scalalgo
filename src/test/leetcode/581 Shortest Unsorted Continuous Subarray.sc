/*
 find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 */

def findUnsortedSubarray(nums: Array[Int]): Int = {
  val sorted = nums.sorted
  val unmatch = nums.indices.filter(x=> sorted(x)!=nums(x))

  if(unmatch.isEmpty) 0 else unmatch.max - unmatch.min + 1
}

findUnsortedSubarray(Array(2,6,4,8,10,9, 15))