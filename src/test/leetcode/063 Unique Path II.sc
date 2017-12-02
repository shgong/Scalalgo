def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = {
  val h = obstacleGrid.length
  val w = obstacleGrid(0).length

  val d = Array.fill(h)(Array.fill(w)(0))
  if(obstacleGrid(0)(0)==0) d(0)(0) = 1
  for(i<-0 until h; j<-0 until w){
      if(obstacleGrid(i)(j)==1) 0
      else {
        if(j>0) d(i)(j) += d(i)(j-1)
        if(i>0) d(i)(j) += d(i-1)(j)
      }
  }
  d(h-1)(w-1)
}

val q = Array(0,0,0,0,1,0,0,0,0).sliding(3,3).toArray

uniquePathsWithObstacles(q)