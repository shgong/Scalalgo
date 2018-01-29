case class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end

  override def toString() = s"[$start,$end]"
}

class SummaryRanges() {

  /** Initialize your data structure here. */
  val s = collection.mutable.ArrayBuffer[Interval]()

  import collection.Searching._


  def addNum(`val`: Int): Unit = {

    var hi = s.length
    var lo = 0
    while (lo < hi) {
      val mid = (hi + lo) / 2
      if (s(mid).start < `val`) lo = mid + 1
      else hi = mid
    }

    // lo-1 < val, lo >= val

    if (lo == s.length) {
      if(lo == 0 || `val`>s(lo-1).end + 1) s.insert(lo, new Interval(`val`, `val`))
      else if (`val` == s(lo-1).end + 1) s(lo-1) = new Interval(s(lo-1).start, `val`)
    }
    else if (lo == 0) {
      if (s(0).start == `val`) ()
      else if (s(0).start == `val` + 1) s(0) = new Interval(`val`, s(0).end)
      else s.insert(0, new Interval(`val`, `val`))
    }
    else {
      if (s(lo).start <= `val` + 1 && s(lo - 1).end >= `val` - 1) {
        s(lo - 1) = new Interval(s(lo - 1).start, s(lo).end)
        s.remove(lo)
      } else if (s(lo).start == `val` + 1) {
        s(lo) = new Interval(`val`, s(lo).end)
      } else if (s(lo - 1).end == `val` - 1) {
        s(lo - 1) = new Interval(s(lo - 1).start, `val`)
      } else if (`val` > s(lo - 1).end + 1 && `val` < s(lo).start - 1) {
        s.insert(lo, new Interval(`val`, `val`))
      }
    }


  }

  def getIntervals(): List[Interval] = s.toList


}

val q = new SummaryRanges()
for (i <- List(49,97,53,5,33,65,62,51,100,38,61,45,74,27,64,17,36,17,96,12,79,32,68,90,77,18,39,12,93,9,87,42,60,71,12,45,55,40,78,81,26,70,61,56,66,33,7,70,1,11,92,51,90,100,85,80,0,78,63,42,31,93,41,90,8,24,72,28,30,18,69,57,11,10,40,65,62,13,38,70,37,90,15,70,42,69,26,77,70,75,36,56,11,76,49,40,73,30,37,23)) {
  q.addNum(i)
  println(q.getIntervals())
}