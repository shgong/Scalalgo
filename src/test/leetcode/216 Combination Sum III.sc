/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 */

// only 1-9, k numbers restriction
// dfs
def combinationSum(k:Int, n:Int): List[List[Int]] = {
  val c = 1 to 9

  val solutionSet = collection.mutable.ArrayBuffer[List[Int]]()

  def search(item: Int, k: Int, n:Int, ls: List[Int]): Unit = {
    if (n == 0 && k==0) solutionSet.append(ls)
    else if (item < 10 && n>0 && k>0) {
      search(item + 1, k, n, ls)
      search(item+ 1, k-1, n-item, item::ls)
    }
  }

  search(1, k, n, Nil)
  solutionSet.toList
}

combinationSum(3, 9)