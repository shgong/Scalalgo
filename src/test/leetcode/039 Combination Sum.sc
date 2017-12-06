import scala.collection.mutable.ArrayBuffer

/*

Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
 */

// dfs
def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
  val c = candidates.sorted
  val l = c.length
  val solutionSet = ArrayBuffer[List[Int]]()

  def search(item: Int, target: Int, ls: List[Int]): Unit = {
    if (target == 0) solutionSet.append(ls)
    else if (item < l && target >= c(item)) {
      val currentItem = c(item)
      var toAppend: List[Int] = Nil
      for (i <- 0 to target / currentItem) {
        search(item + 1, target - i * currentItem, ls ++ toAppend)
        toAppend = currentItem :: toAppend
      }
    }
  }

  search(0, target, Nil)
  solutionSet.toList
}

combinationSum(Array(1), 1)

