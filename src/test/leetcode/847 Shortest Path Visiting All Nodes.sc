/*
847. Shortest Path Visiting All Nodes

An undirected, connected graph of N nodes

graph.length = N
j != i is in the list graph[i] exactly once
if and only if nodes i and j are connected.

length of the shortest path that visits every node.

1 <= graph.length <= 12


 */

def shortestPathLength(graph: Array[Array[Int]]): Int = {
  val N = graph.length

  // DP, find minimum path with subsets
  // A path 'state' can be represented as the subset of nodes visited,
  // plus the current 'head' node.
  val dist = Array.fill(1 << N)(Array.fill(N)(N * N))

  // single node
  for (x <- 0 until N) dist(1 << x)(x) = 0

  for (cover <- 0 until (1 << N)) {
    var repeat = true
    while (repeat) {
      repeat = false
      for {
        head <- 0 until N
        d = dist(cover)(head)         // each head of current cover
        next <- graph(head)           // try possible next
        cover2 = cover | (1 << next)  // new cover and new next head
        if d + 1 < dist(cover2)(next) // if smaller than existing distance
      } {
        dist(cover2)(next) = d + 1
        if (cover == cover2) repeat = true
        // need repeat if distance in the same cover get updated
      }
    }

  }

  // cover all nodes
  (dist((1 << N) - 1) :+ N * N).min
}

shortestPathLength(
  Array(
    Array(1, 2, 3),
    Array(0),
    Array(0),
    Array(0))
)

//[[1],[0,2],[1,3],[2],[1,5],[4]]
shortestPathLength(
  Array(
    Array(1),
    Array(0, 2),
    Array(1, 3),
    Array(2),
    Array(1, 5),
    Array(4))
)

//[[2,3],[7],[0,6],[0,4,7],[3,8],[7],[2],[5,3,1],[4]]
shortestPathLength(
  Array(
    Array(2, 3),
    Array(7),
    Array(0, 6),
    Array(0, 4, 7),
    Array(3, 8),
    Array(7),
    Array(2),
    Array(5, 3, 1),
    Array(4)
  )
)
