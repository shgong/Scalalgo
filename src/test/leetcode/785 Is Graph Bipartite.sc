import scala.collection.mutable.ArrayBuffer

/*
785. Is Graph Bipartite

Recall that a graph is bipartite
if we can split it's set of nodes into two independent subsets A and B
such that every edge in the graph
has one node in A and another node in B.

The graph is given in the following form:
graph[i] is a list of indexes j
for which the edge between nodes i and j exists.

Each node is an integer between 0 and graph.length - 1
There are no self edges or parallel edges
graph[i] does not contain i, and it doesn't contain any element twice.
 */

/*

The graph is given in the following form:
graph[i] is a list of indexes j
for which the edge between nodes i and j exists.

READ CAREFULLY
 */
def isBipartite(graph: Array[Array[Int]]): Boolean = {

  val l = graph.length
  val color:Array[Int] = Array.fill(l)(-1)

  for(start <- 0 until l if color(start)== -1) {

    val queue = collection.mutable.Queue[Int](start)
    color(start) = 1

    while (queue.nonEmpty) {
      val node = queue.dequeue()
      for (y <- graph(node)) {
        if (color(y) == color(node)) return false
        if (color(y) == -1) {
          color(y) = 1 - color(node)
          queue.enqueue(y)
        }
      }
    }

  }
  true
}
