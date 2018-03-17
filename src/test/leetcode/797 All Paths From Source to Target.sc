/*
Given a directed, acyclic graph of N nodes.
Find all possible paths from node 0 to node N-1,
and return them in any order.

The graph is given as follows:
the nodes are 0, 1, ..., graph.length - 1.
graph[i] is a list of all nodes j
          where the edge (i, j) exists
 */

def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {
  var res: List[List[Int]] = Nil
  val l = graph.length

  def find(n:Int, pre:List[Int]): Unit = {
    for(i<- graph(n)) {
      if(i==l-1) res ::= (i::pre).reverse
      find(i, i::pre)
    }

  }

  find(0, List(0))
  res
}


val q = Array(Array(1,2),Array(3),Array(3),Array[Int]())
allPathsSourceTarget(q)