// TwoSum
// Keep hashmap to check back

def twoSum(nums: Array[Int], target: Int): Array[Int] = {

  val h = new collection.mutable.HashMap[Int, Int]()

  nums.view.zipWithIndex.foreach { case (num, i) =>
    val res = target - num
    if (h.contains(res)) return Array(h(res), i)
    h(num) = i
  }
  return Array(-1, -1)
}

