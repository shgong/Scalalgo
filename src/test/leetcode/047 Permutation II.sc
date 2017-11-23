// unique

def permuteUnique(nums: Array[Int]): List[List[Int]] = {
  nums.toList.permutations.toList
}

// if iterative solution
//    skip numbers same as last one

permuteUnique(Array(1,1,2))