def minCostClimbingStairs(cost: Array[Int]): Int = {
  var cost0: Int = 0  // skip this
  var cost1: Int = 0  // take this

  for(i<-cost){
    var temp = (cost1 min cost0) + i
    cost0 = cost1
    cost1 = temp
  }

  cost0 min cost1
}

minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1))