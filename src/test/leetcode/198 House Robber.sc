
// can not break in adjacent houses
// given array of money in each house
// solve max money to rob

def rob(nums: Array[Int]): Int = {

  if(nums.isEmpty) return 0
  if(nums.length==1) return nums(0)

  var max1 = nums(0)
  var max2 = nums(0) max nums(1)
  for (i <- nums.drop(2)){
    val tmp = (max1 + i) max max2
    max1 = max2
    max2 = tmp
  }
  max2
}

rob(Array(1,9,8,3,4,12,1))