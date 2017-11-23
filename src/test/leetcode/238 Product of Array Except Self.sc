// scan
def productExceptSelf_Scan(nums: Array[Int]): Array[Int] = {
  val l = nums.scanLeft(1)(_*_)
  val r = nums.scanRight(1)(_*_)
  nums.indices.toArray.map(x=> l(x)*r(x+1))
}

// another
def productExceptSelf(nums: Array[Int]): Array[Int] = {
  val len = nums.length
  val res = nums.clone()

  var p = 1
  for(i<-0 until len){
    res(i) = p
    p *= nums(i)
  }

  p = 1
  for(i<-len-1 to 0 by -1){
    res(i) *= p
    p *= nums(i)
  }

  res
}




// given [1,2,3,4], return [24,12,8,6].

productExceptSelf(Array(1,2,3,4))

