
// return 0 when overflow
def reverse(x: Int): Int = {

  val sign = if (x > 0) 1 else -1
  var _x = sign * x
  var y = 0
  var last = 0

  while (_x > 0) {
    y *= 10
    y += _x % 10

    // handle overflow
    if ((y-_x % 10) / 10 != last) return 0
    last = y

    _x /= 10
  }

  sign * y
}

reverse(1534236469)
reverse(-123)