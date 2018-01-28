// 774. Minimize Max Distance to Gas Station

// binary search the best max distance
def minmaxGasDist(stations: Array[Int], K: Int): Double = {

  val l = stations.length
  val distances = stations.sliding(2).toList.map {
    case Array(a, b) => (b - a).toDouble
  }

  var low = 0.0
  var high = 100000009.0

  for (_ <- 0 until 80) {
    val h = (high + low) / 2
    val need = distances.map(x => (x / h).toInt).sum
    if (need > K) low = h else high = h
  }
  low
}

minmaxGasDist(
  Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
  9
)

