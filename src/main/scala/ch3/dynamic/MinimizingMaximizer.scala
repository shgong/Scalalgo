package ch3.dynamic

import scala.collection.mutable

object MinimizingMaximizer {

  /*
    Maximizer is a n-number max calculator, constructed from N sorter
    Sorter k sort k-1 result from (s_k to t_k)
    Given a sorter sequence
    Find the min subset (in the same order) that still works
  */

  def solve(stPairs: List[(Int,Int)]) = {

    // must sort smaller part first, then cover last of previous smaller part
    // just consider extreme case, first is max

    /* stack is wrong can not throw away, need dp
    val stack = mutable.Stack((0,1))
    for((s,t)<-stPairs){
      if((t>stack.top._2 && s<=stack.top._2) || (t==stack.top._2 && s<=stack.top._1)) {
        while (stack.top._1 >= s) stack.pop()
        stack.push((s,t))
      }
    }
    stack.reverse
    */

    // segment tree ?


  }

  def main(args: Array[String]): Unit = {

    val testCases = List(
      List((20,30),(1,10),(10,20),(20,30),(15,25),(30,40)),
      List((20,30),(1,10),(10,20),(20,30),(15,25),(30,40)),
      List((20,30),(1,10),(10,20),(15,25),(20,30),(15,25),(25,30),(30,40)),
      List((20,30),(1,10),(1,20),(20,30),(15,25),(30,40))
    )

    testCases.map(x=> println(solve(x)))

  }
}
