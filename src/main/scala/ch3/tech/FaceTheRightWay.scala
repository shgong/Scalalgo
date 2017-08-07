package ch3.tech

import scala.collection.{BitSet, mutable}

// N cow in a line
// flip machine can flip K continuous cows
// find minimum round M and corresponding K to make all face F
//
// BFFBFBB
// K=3 M=3

object FaceTheRightWay {

  // start from first cow, try each K, K in 0 to N, O(N3)

  // optimize
  // f[i] = if [i, i+K-1] has flipped
  // for each cow, if sum(i-K+1 to i-1) f(i) = odd, it is different from starting direction
  // sum(i+1-K+1 to i) = sum(i-K+1 to i-1) + f(i) - f(i-K+1)

  def solve(faces: BitSet, N:Int): Unit = {

    // solve K machine
    def calc(K: Int): Int = {
      val f = mutable.BitSet()
      var res = 0
      var sum = 0
      for (i <- 0 to N - K) {
        // if cow i need flip
        if ((faces(i) && sum % 2 == 0) || (!faces(i) && sum % 2 == 1)) {
          f += i
          res += 1
        }

        // calc existing flipping for next cow
        if (f(i)) sum += 1
        if(i-K+1>=0 && f(i-K+1)) sum -= 1
      }

      for(i <- N-K+1 until N){
        // if any cow still need flip
        if ((faces(i) && sum % 2 == 0) || (!faces(i) && sum % 2 == 1)) {
          return -1
        }
        if(i-K+1>=0 && f(i-K+1)) sum -= 1
      }

      // if success, return flip times
      res
    }

    (1 to N).map(x=>(calc(x),x)).filter(_._1 >= 0).min

  }

}
