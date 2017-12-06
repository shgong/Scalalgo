
/*
Each number in C may only be used once in the combination.
 */

// dfs
def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
  val c = candidates.groupBy(identity).mapValues(_.length).toList.sorted
  val l = c.length
  val solutionSet = collection.mutable.ArrayBuffer[List[Int]]()

  def search(item: Int, target: Int, ls: List[Int]): Unit = {
    if (target == 0) solutionSet.append(ls)
    else if (item < l && target >= c(item)._1) {
      val currentItem = c(item)._1
      var toAppend: List[Int] = Nil
      for (i <- 0 to Math.min(target / currentItem, c(item)._2)) {
        search(item + 1, target - i * currentItem, ls ++ toAppend)
        toAppend = currentItem :: toAppend
      }
    }
  }

  search(0, target, Nil)
  solutionSet.toList
}

combinationSum(Array(10,1,2,7,6,1,5), 8)

