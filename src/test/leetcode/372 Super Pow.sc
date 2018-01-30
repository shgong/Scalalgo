//  calculate ab mod 1337
// where a is a positive integer and
// b is an extremely large positive integer
// given in the form of an array

val M = 1337
def superPow(a: Int, b: Array[Int]): Int = {

  var res = 1
  var current = a % M

  for(i<-b.reverse){
    val a2 = current * current % M
    val a4 = a2 * a2 % M
    val a8 = a4 * a4 % M

    val last = i match {
      case 0 => 1
      case 1 => current
      case 2 => a2
      case 3 => a2 * current % M
      case 4 => a4
      case 5 => a4 * current % M
      case 6 => a2 * a4 % M
      case 7 => a2 * a4 * current % M
      case 8 => a8
      case 9 => a8 * current % M
    }


    res = res * last % M
    current = a8 * a2 % M
  }

  res
}

superPow(2, Array(1,0))