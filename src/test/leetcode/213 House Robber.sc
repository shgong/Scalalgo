
// can not break in adjacent houses
// given array of money in each house
// solve max money to rob

// all house in a circle

def rob(nums:Array[Int]): Int = {
  (nums(0) + rob1(nums.drop(2).dropRight(1))) max rob1(nums.drop(1))
}

def rob1(nums: Array[Int]): Int = {

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
