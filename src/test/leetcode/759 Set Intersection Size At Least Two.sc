/*
Find the minimum size of a set S
such that for every integer interval A in intervals,
the intersection of S with A has size at least 2.

Find the minimum size of a set S

 */

def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
  val sets = intervals.map(x=> (x(0),x(1))).sortBy(_._1)
  println(sets.toList)

  3
}

intersectionSizeTwo(
  Array(Array(1,3),Array(1,4),Array(2,5),Array(3,5))
)