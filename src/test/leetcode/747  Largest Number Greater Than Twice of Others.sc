
def dominantIndex(nums: Array[Int]): Int = {
  var max = Integer.MIN_VALUE
  var ind = -1
  var max2 = Integer.MIN_VALUE

  for(i<- 0 until nums.length){
    val num = nums(i)
    if(num>max) {
      max2 = max
      max = num
      ind = i
    } else if(num>max2){
      max2 = num
    }
  }

  if(max>=2*max2) ind else -1
}

dominantIndex(Array(2,3,3,6,1))
dominantIndex(Array(0,2,3,0))

