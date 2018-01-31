def findDuplicates(nums: Array[Int]): List[Int] = {
  // use array to mark extra information
  var res: List[Int] = Nil
  for(i<-0 until nums.length){
    val v = Math.abs(nums(i))
    if(nums(v-1)<0) res ::= v
    nums(v-1) = - nums(v-1)
  }
  res
}

findDuplicates(Array(4,3,2,7,8,2,3,1))