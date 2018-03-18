def findLengthOfLCIS(nums: Array[Int]): Int = {
  val l = nums.length
  var last = false
  var cur = 1
  var max = 1

  if(nums.length<=1) return nums.length

  for(i<-0 until l-1){
    if(nums(i+1)>nums(i)){
      if(last) cur += 1
      else {
        cur = 2
        last = true
      }
    } else {
      last = false
      max = max max cur
      cur = 1
    }
  }
  max max cur
}