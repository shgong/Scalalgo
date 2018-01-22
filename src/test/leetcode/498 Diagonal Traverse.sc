def findDiagonalOrder(matrix: Array[Array[Int]]): Array[Int] = {
  val m = matrix.length
  if(m==0) return Array()
  val n = matrix.head.length

  (0 to m+n-2).toArray flatMap { sum =>
    val line = for(i<-0 until m; j=sum-i if j>=0 && j<n)
        yield matrix(i)(j)
    if(sum%2==1) line else line.reverse
  }
}

import helper.Util._

val q = arrayArray[Int]("[[1,2,3],[4,5,6],[7,8,9]]")

findDiagonalOrder(q)