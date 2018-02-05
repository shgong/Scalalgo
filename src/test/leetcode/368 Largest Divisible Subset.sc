/*
Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

a set, next must be multiples of all prev
only need to test the largest element
 */
def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
  val m = collection.mutable.HashMap(-1 -> List[Int]())
  for(i<- nums.sorted) m(i) = i :: m.filterKeys(x=> i % x == 0).values.maxBy(_.length)
  m.values.maxBy(_.length).reverse
}

largestDivisibleSubset(Array(1,2,4,8))