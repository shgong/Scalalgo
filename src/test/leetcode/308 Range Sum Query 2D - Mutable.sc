class NumMatrix(_nums: Array[Array[Int]]) {

  val h = _nums.length
  val w = _nums(0).length

  val nums = Array.fill(h)(Array.fill(w)(0))
  val BIT = Array.fill(h + 1)(Array.fill(w + 1)(0))

  for (i <- 0 until h; j <- 0 until w) update(i, j, _nums(i)(j))

  // BIT update
  def update(row: Int, col: Int, v: Int): Unit = {
    val delta = v - nums(row)(col)
    nums(row)(col) = v

    var i = row + 1
    while (i <= h) {
      var j = col + 1
      while (j <= w) {
        BIT(i)(j) += delta
        j += (j & -j)
      }
      i += (i & -i)
    }
  }

  println(BIT.toList.map(_.toList))

  def sum(row:Int, col:Int): Int = {
    var result = 0
    var i = row
    while(i>0){
      var j = col
      while(j>0){
        result += BIT(i)(j)
        j -= j & -j
      }
      i -= i & -i
    }

    result
  }

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int =
    sum(row2+1, col2+1) + sum(row1, col1) - sum(row1, col2+1) - sum(row2+1, col1)

}


val c = new NumMatrix(Array(
  Array(1, 2, 3),
  Array(4, 5, 6),
  Array(7, 8, 9)
))

c.sumRegion(1, 1, 2, 2)