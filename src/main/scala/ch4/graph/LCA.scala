package ch4.graph

object LCA {

  // Lowest Common Ancestor

  // solution 1

  // go up from each node, depending on the depth
  // will meet some time at the same depth

  // parent is not very efficient
  // try preprocess a 2^k parent graph (2^k parent and depth of each node)

  def solveLCA() = {

  }

  // solution 2

  // DFS traverse the tree, get the sequence (node, depths)
  // common ancestor will appear between two nodes
  // get the node with minimum depth

  // convert to RMQ
  // regional minimum query

  // build a sparse table F[i][j] for minimum value between i and i+ 2^j-1
  // avoid comparison, simply adds up
  // similar to 2^k parent processing

  def solveRMQ() = {

  }

}
