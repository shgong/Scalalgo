
import collection.Searching._

def topKFrequent(words: Array[String], k: Int): List[String] = {
  val map = words.groupBy(identity).mapValues(_.length)
  val m = collection.mutable.ArrayBuffer[(String, Int)]()

  for (item <- map) {
    val x = m.search(item)(
      Ordering.by[(String, Int), (Int, String)](x => (-x._2, x._1))
    ).insertionPoint
    m.insert(x, item)
    if (m.length > k) m.remove(k)

  }
  m.map(_._1).toList
}

val txt = Array("i", "love", "leetcode", "i", "love", "coding")
topKFrequent(txt, 2)