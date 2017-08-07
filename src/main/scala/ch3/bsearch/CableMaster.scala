package ch3.bsearch

/* N ropes with length L_N, cut into K ropes with same length
   get max length of K, to `%.2f`

   K = 11
   L = 8.02, 7.43, 4.57, 5.39
*/

object CableMaster {

  // good for min/max question with a Isotonic function
  def solve(L:Array[Double], K:Int) = {
    var (lo,hi)=(0.0,Double.PositiveInfinity)

    def pass(x:Double): Boolean = L.map(r => (r/x).toInt).sum >= K

    while(hi-lo<0.01){
      val mid = (lo+hi)/2
      if (pass(mid)) lo = mid else hi = mid
    }

    hi
  }

}
