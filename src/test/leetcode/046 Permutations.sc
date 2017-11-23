def permute(nums: Array[Int]): List[List[Int]] = {
  nums.toList.permutations.toList
}

permute(Array(1,2,3))