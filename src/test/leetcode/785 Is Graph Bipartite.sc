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

  if(graph.flatten.isEmpty) return true

  val l = graph.length
  val color:Array[Int] = Array.fill(l)(-1)


  val toVisit = collection.mutable.ArrayBuffer(0 until l:_*)
  import collection.Searching._
  while(toVisit.nonEmpty){

    while(toVisit.nonEmpty && graph(toVisit.head).isEmpty){
      toVisit.remove(0)
    }
    if(toVisit.isEmpty) return true
    val next = toVisit.head
    val queue = collection.mutable.Queue[Int](next)
    color(next) = 1

    while(queue.nonEmpty){
      val node = queue.dequeue()
      val connects = graph(node)

      for(y<-connects){

        if(color(y)== -1) {
          color(y) = 1 - color(node)
          queue.enqueue(y)
        }
        else if(color(y) == color(node)) return false
      }

      toVisit.remove(toVisit.search(node).insertionPoint)
    }
  }
  true
}


isBipartite(Array(Array(1,3),Array(0,2),Array(1,3),Array(0,2)))
isBipartite(Array(Array(1,2,3),Array(0,2),Array(0,1),Array(2,3)))

isBipartite(Array(Array(4),Array(),Array(4),Array(4),Array(0,2,3)))