package ch2.gcj
/*
  two vectors
  allow to swap each dimension inside v1, v2
  find minimum inner product v1.v2

  v1 = [1,3,-5]
  v2 = [-2,4,1]
 */

object MinimumScalarProduct {
  def solve(v1:Array[Int], v2:Array[Int]):Int = {
    v1.sorted.zip(v2.sorted(Ordering[Int].reverse)).map{case(x,y)=>x*y}.sum
  }
}
