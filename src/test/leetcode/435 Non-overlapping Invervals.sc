case class Interval(var start: Int = 0, var end: Int = 0)

/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping
 */


// greedy, remove what ends first
def eraseOverlapIntervals(intervals: Array[Interval]): Int = {
  var q = intervals.sortBy(_.end)
  var remove = 0
  while(q.nonEmpty){
    val initLength = q.length
    val take = q.head
    q = q.filter(_.start >= take.end)
    remove += initLength - 1 - q.length
  }
  remove
}

val q = Array(Interval(1,2), Interval(1,2), Interval(1,2))

eraseOverlapIntervals(q)