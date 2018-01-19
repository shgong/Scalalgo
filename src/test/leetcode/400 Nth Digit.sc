/*
1-9     1
10-99   2
100-999 3
 */


def findNthDigit(n: Int): Int = {
  var x = n
  var bit = 1
  var start = 1

  while (x > 0) {
    // start * 9 * bit might overflow
    val nth = start + (x - 1) / bit
    val digit = (x - 1) % bit
    println(s"$x $nth")

    if(nth <= 9 * start) return nth.toString.apply(digit).toString.toInt
    else x -= start * 9 * bit

    bit += 1
    start *= 10
  }
  -1
}
findNthDigit(1000000000)