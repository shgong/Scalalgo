class MedianFinder() {

  /** initialize your data structure here. */
  import collection.Searching._
  val buffer = collection.mutable.ArrayBuffer[Int]()
  var k = 0

  def addNum(num: Int): Unit = {
    val idx = buffer.search(num).insertionPoint
    buffer.insert(idx, num)
    k += 1
  }

  def findMedian(): Double = {
    if(k % 2 == 1) buffer(k/2) * 1.0
    else buffer(k/2) * 0.5 + buffer(k/2-1) * 0.5
  }
}