/*
787. Cheapest Flights Within K Stops

There are n cities connected by m flights.
Each fight starts from city u and arrives at v with a price w.

Now given all the cities and fights,
together with starting city src and the destination dst,
your task is to find the cheapest price from src to dst
with up to k stops.

If there is no such route, output -1.
 */

def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, K: Int): Int = {
  // bfs
  val price: Map[Int, Array[Array[Int]]] = flights.groupBy(_ (0))

  // city, price, stop
  var total = collection.mutable.HashMap[Int, Int](src -> 0)
  val visited = collection.mutable.HashMap[Int, Int]()


  for (stop <- 0 to K) {
    var next = collection.mutable.HashMap[Int, Int]()

    for {
      (city, money) <- total if price.contains(city)
      Array(u, v, w) <- price(city)
      if !visited.contains(v) || visited(v) > money + w
    } {
      visited(v) = money + w
      next(v) = money + w
    }

    total = next
  }

  visited.getOrElse(dst, -1)
}

findCheapestPrice(
  3, Array(Array(0, 1, 100), Array(1, 2, 100), Array(0, 2, 500)),
  src = 0, dst = 2, K = 0
)