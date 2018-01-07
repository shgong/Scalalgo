// Employee Free Time
// common, positive-length free time for all

case class Interval(var start: Int = 0, var end: Int = 0)

def employeeFreeTime(avails: List[List[Interval]]): List[Interval] = {

  import collection.Searching._
  val free = collection.mutable.ArrayBuffer[Interval]()
  for (i <- avails.flatten) {
    var x = free.search(i)(Ordering.by[Interval, (Int, Int)](x => (x.start, x.end))).insertionPoint
    var toInsert = i

    var test = true
    while (x != 0 && test) {
      val left = free(x - 1)
      if (left.end >= toInsert.start) {
        toInsert.start = toInsert.start min left.start
        toInsert.end = toInsert.end max left.end
        free.remove(x - 1)
        x = x - 1
      } else test = false
    }

    test = true
    while(x<free.length && test){
      val right = free(x)
      if (right.start <= toInsert.end) {
        toInsert.start = toInsert.start min right.start
        toInsert.end = toInsert.end max right.end
        free.remove(x)
      } else test = false
    }

    free.insert(x, toInsert)
    //println(free)
  }

  val res = collection.mutable.ArrayBuffer[Interval]()
  var lastend = Integer.MIN_VALUE
  for(i<-free){
    if(lastend == Integer.MIN_VALUE) lastend = i.end
    else {
      res.append(new Interval(lastend, i.start))
      lastend = i.end
    }

  }

  res.toList
}

employeeFreeTime(
  List(
    List(Interval(1, 2), Interval(5, 6)), List(Interval(1, 3)), List(Interval(4, 10))
  )
)


employeeFreeTime(
  List(
    List(Interval(1, 3), Interval(6, 7)), List(Interval(2, 4)), List(Interval(2, 5), Interval(9,12))
  )
)

/*

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
 */