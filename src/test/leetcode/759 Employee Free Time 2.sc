case class Interval(var start: Int = 0, var end: Int = 0)


def employeeFreeTime(avails: List[List[Interval]]): List[Interval] = {

  // use global sort is much easier
  val all = avails.flatten.sortBy(x=>(x.start, x.end))
  val res = collection.mutable.ArrayBuffer[Interval]()

  var current_start = all.head.start
  var current_end = all.head.end

  for (slot <- all) {
    if (slot.start <= current_end) current_end = current_end max slot.end
    else {
      // sorted, can start new interval
      res.append(Interval(current_end, slot.start))
      current_start = slot.start
      current_end = slot.end
    }
  }

  res.toList
}

employeeFreeTime(List(
    List(Interval(1, 2), Interval(5, 6)), List(Interval(1, 3)), List(Interval(4, 10))
  ))


employeeFreeTime(List(
    List(Interval(1, 3), Interval(6, 7)), List(Interval(2, 4)), List(Interval(2, 5), Interval(9,12))
  ))
