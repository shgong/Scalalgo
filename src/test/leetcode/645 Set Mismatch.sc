def findErrorNums(nums: Array[Int]): Array[Int] = {
  val l = nums.length
  for(i <- 0 until l ){
    while(nums(i)!=i+1 && nums(nums(i)-1)!= nums(i)){
      val tmp = nums(nums(i)-1)
      nums(nums(i)-1) = nums(i)
      nums(i) = tmp
    }
  }
  for(i<- 0 until l if nums(i) != i + 1) return Array(nums(i), i+1)
  Array()
}

findErrorNums(Array(1,2,2,4)).toList
findErrorNums(Array(1,2,5,1,3,4)).toList
findErrorNums(Array(1,2,2,4)).toList