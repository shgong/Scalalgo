package ch4.strategy

object CoinGame1 {

  /*
  Alice and Bob play a game, Given k numbers a[k] (a1=1) and x coins
  Every time player get a[x] coins from the pile
  Alice go first
  Player get last coin win the game
   */

  def solve(a:Array[Int], x:Int): String = {
    /*
    j = 0                     lose
    exist i => j - ai = lose  win
    any i => j - ai = win     lose
     */

    val win = Array.fill(x+1)(0)
    win(0) = -1
    for(i<- 0 to x) {
      if(win(i) == -1)
        for(coin<-a if i+coin<=x)
          win(i+coin) = 1
      else if (win(i)==1)
        for(coin<-a if i+coin<=x)
          if(win(i+coin) == 0) win(i+coin) = -1
    }
    println(win.toList)
    if(win.last > 0) "Alice" else "Bob"
  }


  def main(args: Array[String]): Unit = {

    val testCases = List(
      (Array(1,4), 9),
      (Array(1,4), 10)
    )

    testCases.foreach(x=>println((solve _).tupled(x)))
  }
}
