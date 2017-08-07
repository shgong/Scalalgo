package ch2.gcj

/*
M round gamble starting with money x
each round there is P to win (double) otherwise lose

What's the chance of getting 1 million dollars using best strategy

Sample:
M=1 P=0.5 X=500000 => 0.5
M=3 P=0.75 X=600000 => 0.843750
 */

object Millionaire {

  // 75 =>  bet 25, bet 50
  //        p + (1-p) * p
  // become discreet problem

  def solve(M:Int, P:Double, X:Int)= {


  }

}
