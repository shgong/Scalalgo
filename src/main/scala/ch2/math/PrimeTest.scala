package ch2.math

object PrimeTest {

  def isPrime(n: Int): Boolean = {
    for (i <- 2 to math.sqrt(n).toInt) {
      if (n % i == 0) return false
    }
    n != 1
  }
}
