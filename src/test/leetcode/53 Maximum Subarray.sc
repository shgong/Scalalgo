def maxSubArray(nums: Array[Int]): Int = {
  var min = 0
  var max = Integer.MIN_VALUE

  var sum = 0
  for(i<-nums){
    sum+=i
    if(sum-min>max) max = sum - min
    if(min>sum) min = sum
  }

  max
}

maxSubArray(Array(-2,1,-3,4,-1,2,1,-5,4))