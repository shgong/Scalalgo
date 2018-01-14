def minSwapsCouples(row: Array[Int]): Int = {
  val l = row.length
  val pos = Array.fill(l)(0)
  for(i<-0 until l) pos(row(i)) = i // position map

  var res = 0
  for(i <- 0 until l by 2) {
    if((row(i) ^ row(i+1)) != 1) { // adjacent number
      val p = pos(row(i) ^ 1) // position of ideal match
      row(p) = row(i+1)
      pos(row(i+1)) = p

      // row(i+1) = row(i) ^ 1    no need to go back reset
      // pos(row(i+1)) = i + 1

      res += 1
    }
  }
  res
}

minSwapsCouples(Array(0,2,1,3))
minSwapsCouples(Array(1,4,0,5,8,7,6,3,2,9))
minSwapsCouples(Array(5,4,2,6,3,1,0,7))
