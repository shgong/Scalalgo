

import collection.Searching._

def topKFrequent(nums: Array[Int], k: Int): List[Int] = {
  val map = nums.groupBy(identity).mapValues(_.length)
  val m = collection.mutable.ArrayBuffer[(Int, Int)]()

  for (item <- map) {
    val x = m.search(item)(
      Ordering.by[(Int, Int), (Int, Int)](x => (-x._2, x._1))
    ).insertionPoint
    m.insert(x, item)
    if (m.length > k) m.remove(k)

  }
  m.map(_._1).toList
}