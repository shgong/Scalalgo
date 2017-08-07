package ch3.dynamic

object MinimizingMaximizer {

  /*
    Maximizer is a n-number max calculator, constructed from N sorter
    Sorter k sort k-1 result from (s_k to t_k)
    Given a sorter sequence
    Find the min subset (in the same order) that still works
  */

  def solve(stPairs: List[(Int,Int)]): List[Int] = {
    val (s,t) = stPairs.unzip

    // must sort smaller part first, then cover last of previous smaller part
    // just consider extreme case, first is max
    s

  }

  def main(args: Array[String]): Unit = {

    println(solve(
      List((20,30),(1,10),(10,20),(20,30),(15,25),(30,40))
    ))
  }
}
