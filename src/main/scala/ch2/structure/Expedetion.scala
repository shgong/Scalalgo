package ch2.structure

import scala.collection.mutable

/*
 Drive car to finish L distance, start with P oil
 there are N gas stations along the way, locate at A_i with oil B_i
 Find the minimum times to refill, if cannot reach destination, output -1

 N=4, L=25, P=10
 A = {10,14,20,21}
 B = {10,5,2,4}
 */

object Expedetion {

  /*
  Use the station with most oil when about to run out
  Use Priority Queue, add when pass, remove when out, fail when empty
   */
  def solve(A:Array[Int], B:Array[Int], N:Int, L:Int, P:Int):Int = {
    // destination as a station
    A:+L;B:+0

    val que = mutable.PriorityQueue[Int]()
    var ans = 0
    var pos = 0
    var tank = P

    for(i<-0 to N){
      val d = A(i) - pos
      // may need multiple tanks for one station
      while(tank - d <0) {
        if(que.isEmpty) return -1
        tank += que.dequeue()
        ans +=1
      }
      tank -= d
      // reach a new station
      pos = A(i)
      que.enqueue(B(i))
    }
    ans
  }

  // alternative
  def solve2(A:Array[Int], B:Array[Int], N:Int, L:Int, P:Int):Int = {
    val que = mutable.PriorityQueue[Int]()
    var res = 0

    val distance = (0 +: A :+ L).sliding(2).toList.map(ls => ls(1) - ls(0))
    val gas = B :+ 0
    (P /: distance.zip(gas)) { case (tank, (d, g)) =>
      var oil = tank
      while (oil - d < 0) {
        if (que.isEmpty) return -1
        oil += que.dequeue()
        res += 1
      }
      que.enqueue(g)
      oil - d
    }
    res
  }

}
