def maxArea(height: Array[Int]): Int = {
  var i = 0
  var j = height.length - 1
  var max = 0

  while(i<j){

    max = max max ((height(i) min height(j)) * (j-i))

    println(s"$i $j $max")
    if(height(i)<height(j)){
      // move left, skip lower one
      var k = i+1
      while(k<j && height(k)<height(i)) k += 1
      i = k

    }else{
      // move right, skip lower one
      var k = j-1
      while(k<j && height(k)<height(j)) k -= 1
      j = k
    }
  }

  max

}

maxArea(Array(1,5,2,3,4))