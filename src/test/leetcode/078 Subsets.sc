// return all possible subsets
// foldLeft
def subsets(nums: Array[Int]): List[List[Int]] = {
  nums.toList.foldLeft(List(List[Int]())) { case (l, a) =>
    l ++ l.map(a :: _)
  }
}

subsets(Array(1, 2, 3))