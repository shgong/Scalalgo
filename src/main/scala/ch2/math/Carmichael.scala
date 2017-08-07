package ch2.math

// if for any 1<x<n with x^n mod n = x
// n is called Carmichael Number

object Carmichael {

  // need fast exponential
  // x22 = x16 * x4 * x2

  // Exponentiation by Squaring
  // also called Russian Peasant algorithm in book TAOCP
  def mod_power(X:BigInt, N:BigInt, mod:BigInt) = {
    var res:BigInt = 1
    var n = N
    var x = X
    while(n>0) {
      if((n&1)==1) res = res * x % mod
      x = x * x % mod
      n >>= 1
    }
    res
  }
}
