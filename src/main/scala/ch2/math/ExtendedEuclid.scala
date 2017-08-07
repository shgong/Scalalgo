package ch2.math

// there are infinite blocks on a doubleSix
// start from 0 to 1
// roll a four face dice (a,b,-a,-b)

object ExtendedEuclid {

  // find x, y to have ax+by=gcd(x,y)
  // require gcd(x,y)=1

  /*
   ax+by = bx' + (a%b)y'
      given a = a%b + (a/b) * b
            (a%b)x + (a/b)*bx + by = bx' + (a%b)y'
      yield  y' = x
             x' = (a/b) * x + y
   */

  def extgcd(a: Int, b: Int): (Int, Int) =
    if (b == 0) (1, 0)
    else {
      val (x, y) = extgcd(b, a % b)
      (y, x - (a / b) * y)
    }

}
