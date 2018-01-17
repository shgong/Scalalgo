def mySqrt(x: Int): Int = {

  def search(a: Int, b: Int): Int = {
    if (b - a <= 1) if(b*b<=x) b else a
    else {
      val m = (a + b + 1) / 2
      if (m * m == x) m
      else if (m * m > x) search(a, m)
      else search(m, b)
    }
  }

  search(0, 46340 min x)
}

mySqrt(1)
mySqrt(4)
mySqrt(5)
mySqrt(6)
mySqrt(7)
mySqrt(2147483647)