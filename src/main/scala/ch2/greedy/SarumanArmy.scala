package ch2.greedy

// n points in a line, add flags
// for each point, there should be a flagged point within distance R
// find minimum flag required

object SarumanArmy {

  val r = 10
  val x = Array(1,7,15,20,30,50)

  def solve(r:Int, x:Array[Int]) = {
    var i = 0
    var ans = 0
    val N = x.length

    while(i<N){
      val s = x(i)
      i += 1
      while(i<N && x(i)<s+r) i+=1
      val p = x(i-1)
      while(i<N && x(i)<p+r) i+=1

      ans += 1
    }

    ans
  }

}
