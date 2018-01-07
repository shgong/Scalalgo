/*
Find the minimum size of a set S
such that for every integer interval A in intervals,
the intersection of S with A has size at least 2.

Find the minimum size of a set S

 */

def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
  val sets = intervals.map(x=> (x(0),x(1))).sortBy(_._2)
  println(sets.toList)

  val a = collection.mutable.ArrayBuffer[Int]()

  import scala.collection.Searching._
  for(i<-sets){
    if(a.isEmpty) {
      a.append(i._2 - 1)
      a.append(i._2)
    }
    val i1 = a.search(i._1).insertionPoint
    if(i1==a.length-1){
      a.append(i._2)
    } else if(i1==a.length){
      a.append(i._2 - 1)
      a.append(i._2)
    }
  }

  a.length
}

intersectionSizeTwo(
  Array(Array(1,3),Array(1,4),Array(2,5),Array(3,5))
)

intersectionSizeTwo(
  Array(Array(2,10),Array(3,7),Array(3,15),Array(4,11),Array(6,12),Array(6,16),Array(7,8),Array(7,11),Array(7,15),Array(11,12))
)