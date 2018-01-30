def divide(dividend: Int, divisor: Int): Int = {
  val positive = (dividend>0) == (divisor>0)
  var dend = math.abs(dividend)
  var sor = math.abs(divisor)
  var res = 0

  // problem with abs
  if(dividend == Integer.MIN_VALUE){
    res = 1
    dend = - (dend + sor)
  }

  if(dividend==divisor) 1
  else if(dividend == Integer.MIN_VALUE && sor == 1){
    if(positive)Integer.MAX_VALUE else Integer.MIN_VALUE
  }
  else if(divisor==Integer.MIN_VALUE) 0
  else if(divisor==0) Integer.MAX_VALUE
  else {
    while(dend >= sor) {
      var temp = sor
      var i = 1

      while(dend >= temp){
        dend -= temp
        res += i
        i <<= 1
        if(temp <= Integer.MAX_VALUE/2) temp <<= 1
      }
    }
    if(positive) res else -res
  }
}

divide(1024, 32)
divide(-2147483648, -1)
divide(-2147483648, 1)
divide(2147483647, 1)
divide(-1010369383, -2147483648)
divide(1100540749, -1090366779)

/*
def divide(self, dividend, divisor):
    positive = (dividend < 0) is (divisor < 0)
    dividend, divisor = abs(dividend), abs(divisor)
    res = 0
    while dividend >= divisor:
        temp, i = divisor, 1
        while dividend >= temp:
            dividend -= temp
            res += i
            i <<= 1
            temp <<= 1
    if not positive:
        res = -res
    return min(max(-2147483648, res), 2147483647)
 */