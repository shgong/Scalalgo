class NumMatrix(_matrix: Array[Array[Int]]) {
  val h = _matrix.length
  val w = if(h>0) _matrix(0).length else 0
  val sum = Array.fill(h+1)(Array.fill(w+1)(0))

  for(i<-1 to h; j<-1 to w)
    sum(i)(j) = _matrix(i-1)(j-1) + sum(i-1)(j) + sum(i)(j-1) - sum(i-1)(j-1)

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
    sum(row2+1)(col2+1) + sum(row1)(col1) - sum(row2+1)(col1) - sum(row1)(col2+1)
}

val c = new NumMatrix(Array(
  Array(1,2,3),
  Array(4,5,6),
  Array(7,8,9)
))

c.sumRegion(0,0,1,1)