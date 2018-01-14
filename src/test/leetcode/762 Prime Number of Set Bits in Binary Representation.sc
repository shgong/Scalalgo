// prime-number-of-set-bits-in-binary-representation

// Given two integers L and R, find the count of numbers in the range [L, R] (inclusive) having a prime number of set bits in their binary representation.


def countPrimeSetBits(L: Int, R: Int): Int = {
  val primes = List(2,3,5,7,11,13,17,19,23,29)
  (L to R).count { i =>
    primes.contains(Integer.bitCount(i))
  }
}

countPrimeSetBits(6,10)
countPrimeSetBits(10,15)