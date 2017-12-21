def minPathSum(grid: Array[Array[Int]]): Int = {
  val h = grid.length
  val w = grid(0).length
  val dp = Array.fill(w+1)(Integer.MAX_VALUE)

  dp(1) = 0

  for(i<- 1 to h;j<- 1 to w)
    dp(j) = (dp(j) min dp(j-1)) + grid(i-1)(j-1)

  dp.last
}



import helper.Util
val q = Util.arrayArray[Int]("[[1,2],[1,1]]")
minPathSum(q)