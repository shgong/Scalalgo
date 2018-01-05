def firstMissingPositive(nums: Array[Int]): Int = {
  val l = nums.length
  for(i<- 0 until l) {
    while(nums(i)>0 && nums(i)<=l &&
      nums(i)!=i+1 &&
      nums(i)!=nums(nums(i)-1)) { // no pointless swap
      val v = nums(i)
      val temp = nums(v-1)
      nums(v-1) = v
      nums(i) = temp
    }
  }

  for(i<- 0 until l){
    if(nums(i)!= i+1) return i+1
  }
  // no return, if full like  1,2,3,4
  l+1
}

firstMissingPositive(Array(1,2,0))
firstMissingPositive(Array(3,4,-1,1))
firstMissingPositive(Array(1,1))