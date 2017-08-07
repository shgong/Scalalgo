package ch2.math

// given P1(x1,y1) P2(x2,y2)
// find how many grid point in line segment P1P2

object Euclid {

  // answer is greatest common divisor of (x1-x2) and (y1-y2)
  // O(log(max(a,b)))
  def solve(x1:Int,y1:Int,x2:Int,y2:Int) = {
    gcd(math.abs(x1-x2), math.abs(y1-y2))
  }

  def gcd(a:Int,b:Int):Int= {
    if(b==0) a
    else gcd(b, a%b)
  }

}
