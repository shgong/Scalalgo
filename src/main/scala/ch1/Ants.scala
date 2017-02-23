package ch1

// multiple ant on a stick climbing in 2 directions, reverse if collides, when will the last ant drops

object Ants {

  def solve(l:Int, x:List[Int]) = {
    x.map(x=>math.max(x,l-x)).max
  }

}
