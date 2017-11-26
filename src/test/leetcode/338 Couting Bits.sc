/*

Given a non negative integer number num.
For every numbers i in the range 0 ≤ i ≤ num
calculate the number of 1's in their binary representation
return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].
 */

def countBits(num: Int): Array[Int] = {
  if (num == 0) return Array(0)

  val res = new Array[Int](num+1)
  res(0) = 0
  var i = 1
  var segment = 1

  while (i <= num) {
    while (i < 2 * segment && i <= num) {
      res(i) = res(i - segment) + 1
      i += 1
    }
    segment <<= 1
  }
  res
}
