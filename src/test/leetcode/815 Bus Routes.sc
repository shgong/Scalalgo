// 815. Bus Routes
/*

We have a list of bus routes.
Each routes[i] is a bus route that the i-th bus repeats forever.

For example if routes[0] = [1, 5, 7],
the first bus (0-th indexed) travels in the sequence
1->5->7->1->5->7->1->...

We start at bus stop S (initially not on a bus),
we want to go to bus stop T

what is the least number of buses we must take to reach our destination?
Return -1 if it is not possible.
 */

def numBusesToDestination(routes: Array[Array[Int]], S: Int, T: Int): Int = {
  val l = routes.length
  val set = collection.mutable.Set(0 until l:_*) // rest routes
  val next = collection.mutable.Set[Int](1)
  var current = Set(S)

  if (S == T) return 0
  var stops = 0

  // bfs
  while(next.nonEmpty){
    next.clear()

    for(routeId <- set) {
      if(routes(routeId).exists(current.contains(_))){
        set.remove(routeId)
        next.add(routeId)
      }
    }

    stops += 1
    current = next.flatMap(routes(_)).toSet
    if(current.contains(T)) return stops
  }

  -1
}

numBusesToDestination(
  Array(Array(1, 2, 7), Array(3, 6, 7)),
  1,
  6
)

numBusesToDestination(
  Array(Array(1, 2, 7), Array(3, 9, 7), Array(9,12), Array(12,6)),
  1,
  6
)

numBusesToDestination(
  Array(Array(1, 2, 7), Array(3, 9, 7), Array(9,12), Array(12,6), Array(18, 21)),
  1,
  18
)