
/*
          100
        10000
       100000

  bit & 1010101010
  or
  4^n - 1 = (2^n + 1) * (2^n - 1)
      must be multiple of three
 */

def isPowerOfFour(num: Int): Boolean = {
  num>0 && (num & (num-1)) == 0 && ((num-1) % 3 == 0)
}