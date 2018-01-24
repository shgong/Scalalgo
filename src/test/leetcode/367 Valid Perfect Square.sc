// Newton solve sqrt

def isPerfectSquare(num: Int): Boolean = {
  var x:Long = num
  while (x * x > num) {
    x = (x + num / x) >> 1
  }
  x * x == num
}

isPerfectSquare(9)
isPerfectSquare(16)
isPerfectSquare(14)
isPerfectSquare(121)