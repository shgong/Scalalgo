package ch3.bsearch

// n item with weight  & value, pick k to maximize value per weight
// (w,v) = (2,2),(5,3),(2,1)
// pick 2 => (2,2), (2,1)

object MaximizeAverage {

  // sort by value/weight and greedy? does not work
  // weight also effect

  // how to choose criterion?
  // pass(x) = possible to make value/weight >= x
  // if we have x, Sum(k)(v-x*w)>=0 can be solved by greedy algorithm

  def solve(w:Array[Int], v:Array[Int], k:Int) = {
    var (lo,hi)=(0.0,Double.PositiveInfinity)

    def pass(x:Double): Boolean = w.zip(v).map{case(a,b)=>b-x*a}.sorted.take(k).sum >= 0

    while(hi-lo<0.01){
      val mid = (lo+hi)/2
      if (pass(mid)) lo = mid else hi = mid
    }

    hi

  }

}
