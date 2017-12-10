/*

Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers.

If the answer does not exist, return -1.0.
 */

def calcEquation(equations: Array[Array[String]], values: Array[Double], queries: Array[Array[String]]): Array[Double] = {

  val m = collection.mutable.HashMap[String, collection.mutable.HashMap[String, Double]]()

  for ((Array(a, b), c) <- equations.zip(values)) {
    if (m.contains(a)) {
      m(a)(b) = c
    } else {
      m(a) = collection.mutable.HashMap(b -> c)
    }

    if (m.contains(b)) {
      m(b)(a) = 1 / c
    } else {
      m(b) = collection.mutable.HashMap(a -> 1 / c)
    }
  }

  def search(l: String, r: String, searched:List[String]): Double = {
    if (!m.contains(l)) -1.0
    else if (l == r) 1.0
    else {
      for ((a, b) <- m(l) if !searched.contains(a)) {
        val res = search(a, r, a::searched)
        if (res != -1.0) {
          val rr = b * res
          m(l)(r) = rr
          return rr
        }
      }
      -1.0
    }
  }

  queries.map { case Array(a, b) => search(a, b, Nil) }
}

calcEquation(Array(Array("a", "b"), Array("b", "c")), Array(2.0, 3.0), Array(Array("a", "c"), Array("b", "a"), Array("a", "e"), Array("a", "a"), Array("x", "x"))).toList