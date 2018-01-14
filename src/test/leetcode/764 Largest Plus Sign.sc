// Largest Plus Sign
// In a 2D grid from (0, 0) to (N-1, N-1),
// every cell contains a 1,
// except those cells in the given list mines which are 0

// What is the largest axis-aligned plus sign of 1s
// contained in the grid

// return plus sign order

def orderOfLargestPlusSign(N: Int, mines: Array[Array[Int]]): Int = {
  val g = Array.fill(N)(Array.fill(N)(Integer.MAX_VALUE))
  for(i<-0 until N; j<-0 until N){
    g(i)(j) = List(i+1,j+1,N-i,N-j).min
  }

  for(Array(x,y)<-mines){
    g(x)(y) = 0
    for(j<-x-1 to 0 by -1) g(j)(y) = g(j)(y) min (x-j)
    for(j<-x+1 to N-1) g(j)(y) = g(j)(y) min (j-x)

    for(j<-y-1 to 0 by -1) g(x)(j) = g(x)(j) min (y-j)
    for(j<-y+1 to N-1) g(x)(j) = g(x)(j) min (j-y)
  }

  //println(g.toList.map(_.toList))
  g.map(_.max).max
}

orderOfLargestPlusSign(5, Array(Array(4,2)))
orderOfLargestPlusSign(1, Array(Array(0,0)))