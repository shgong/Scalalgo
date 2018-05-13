/*
834. Sum of Distances in Tree

An undirected, connected tree with N nodes, N-1 edges
The ith edge connects nodes edges[i][0] and edges[i][1] together.

Return a list ans,
where ans[i] is the sum of the distances between node i and all other nodes.


*/

def sumOfDistancesInTree(N: Int, edges: Array[Array[Int]]): Array[Int] = {

  val ch = Array.fill(N)(List[Int]())
  val dtc = Array.fill(N)(0)
  val dc = Array.fill(N)(0)
  val d = Array.fill(N)(0)

  // should only iterate edges once, no bfs
  for (Array(i, j) <- edges) {
    ch(i) ::= j
    ch(j) ::= i
  }

  // tree node may not be in order, can not start 0 - N
  // must do traverse
  def traverse(n: Int): Unit = {
    for (other <- ch(n)) {
      ch(other) = ch(other).filter(_ != n)
      traverse(other)
      dc(n) += dc(other) + 1
      dtc(n) += dc(other) + dtc(other) + 1
    }
  }

  traverse(0)
  d(0) = dtc(0)

  def calc(i: Int): Unit = {
    for (c <- ch(i)) {
      d(c) = d(i) - 2 * dc(c) + N - 2
      calc(c)
    }
  }

  calc(0)
  d
}


sumOfDistancesInTree(
  6,
  Array(Array(0, 1), Array(0, 2), Array(2, 3), Array(2, 4), Array(2, 5))

)

sumOfDistancesInTree(
  3,
  Array(Array(2, 1), Array(0, 2))
)


sumOfDistancesInTree(
  4,
  Array(Array(2, 1), Array(3, 2), Array(3, 0))
)