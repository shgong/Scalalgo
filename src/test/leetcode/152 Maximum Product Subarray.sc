def maxProduct(nums: Array[Int]): Int = {

  var min:Int = 0
  var max:Int = 0
  var g:Int = Integer.MIN_VALUE

  for(i<-nums){
    if(max == 0){
      max = i
      min = i
    } else if(i!=0) {
      val tmp = (max * i) max (min * i) max i
      min = (min * i) min (max * i) min i
      max = tmp
    } else {
      max = 0
      min = 0
    }

    if(max>g) g = max
  }

  g
}

maxProduct(Array(2,3,-2,4))