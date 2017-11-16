def removeElement(nums: Array[Int], `val`: Int): Int = {
  if(nums.isEmpty) return 0
  var i = 0
  var j = nums.length - 1
  while(i<j){
    while(i<j && nums(i)!=`val`) i+=1
    while(i<j && nums(j)==`val`) j-=1
    if(i<j) {
      nums(i) = nums(j)
      nums(j) = `val`
    }
  }
  println(nums.toList)
  val length = if(nums(i)==`val`) i else i+1
  length
}

removeElement(Array(3,2,2,3), 3)
removeElement(Array(2,3,2,3,2), 3)