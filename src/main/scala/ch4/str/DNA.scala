package ch4.str

// given S, find how many length n string don't include S

// Suffix automaton

object DNA {

  // use dp, keep last 3 char as state
  // like S = ATCG, there is 4^3 state

  // state compression
  // A, AT, ATC, other
  // when S is longer
  // A, AT, ATC, ATCA, ATCAT, ATCATC, first belong to longer state

  // use state table to do DP

  def solve(n:Int, S:String): Int = {

    1
  }


  def main(args:Array[String]) = {
    val res = solve(n=3, S="AT")
    println(res)
  }

}
