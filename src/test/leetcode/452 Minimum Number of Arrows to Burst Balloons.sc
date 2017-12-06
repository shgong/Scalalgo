// Greedy
// shot ballons with different x range with min arrows

def findMinArrowShots(points: Array[Array[Int]]): Int = {

  val pts = points.toList.map{case Array(a,b) => (a,b)}.sortBy(_._1).sortBy(_._2)

  var shots = 0
  var lastShot = Integer.MIN_VALUE

  for((left,right)<-pts){
    if(left > lastShot) {
      lastShot = right
      shots += 1
    }
  }

  shots
}


import helper.Util._
val q = arrayArray[Int]("[[10,16], [2,8], [1,6], [7,12]]")
// 2 arrow, x=6 and x=10
findMinArrowShots(q)