// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

/*
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

 */

def numTrees(n: Int): Int = {
  val r = Array.fill(n+1)(0)
  r(0) = 1
  for(i<-1 to n) {
    var total = 0
    for(j<-1 to i)  // root position
      total += r(j-1) * r(i-j) // use prev result
    r(i) = total
  }

  r.last
}

numTrees(3)
numTrees(5)