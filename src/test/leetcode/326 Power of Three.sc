// 3^n

def isPowerOfThree(n: Int): Boolean = {
  n > 0 && 1162261467 % n == 0
}