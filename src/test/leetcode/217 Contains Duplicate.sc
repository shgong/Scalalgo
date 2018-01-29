def containsDuplicate(nums: Array[Int]): Boolean = {
  nums.zipWithIndex.groupBy(_._1).exists(_._2.length != 1)
}

containsDuplicate(Array(1, 2, 3, 4, 5))
containsDuplicate(Array(1, 2, 3, 4, 1))
containsDuplicate(Array(1, 2, 3, 4, 3))
containsDuplicate(Array(0))