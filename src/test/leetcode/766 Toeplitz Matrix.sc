// 766. Toeplitz Matrix

def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {

  val h = matrix.length // 3
  if(h==0) return false
  val w = matrix(0).length // 4

  for(dif<- -h+1 until w){
    val line = for(i<-h-1 to 0 by -1; j=i + dif if j>=0 && j<w) yield matrix(i)(j)
    if(line.groupBy(identity).toList.length != 1) return false
  }
  true
}

val q= Array(Array(1,2,3,4),Array(5,1,2,3),Array(9,5,1,2))

isToeplitzMatrix(q)