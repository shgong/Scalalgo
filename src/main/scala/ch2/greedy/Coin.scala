package ch2.greedy

// pay A dollar with 1,5,10,50,100,500 coins with least coins

object Coin {

  val value = Array(1,5,10,50,100,500)

  def solve(number:Array[Int], target:Int): Unit ={
    var a = target
    value.zip(number).reverse.map { case (v,n) =>
      val t = math.min(a/v,n)
      a -= t*v
      t
    }.sum
  }

}
