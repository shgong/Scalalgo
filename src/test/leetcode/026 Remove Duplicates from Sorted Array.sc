def removeDuplicates(nums: Array[Int]): Int = {
  var i = 0
  var j = 0
  var l = nums.length
  while (j < l) {
    while (j < l - 1 && nums(j) == nums(j + 1)) j += 1
    nums(i) = nums(j)
    i += 1
    j += 1
  }
  println(nums.toList)
  i
}

removeDuplicates(Array(1,2,2,2,3,3,3,3,4))