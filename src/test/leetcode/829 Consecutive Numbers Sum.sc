/*
829. Consecutive Numbers Sum
Given a positive integer N,
how many ways can we write it as a sum of consecutive positive integers?

 Thus, it's sufficient to iterate over all integers m from 1 to sqrt(2n) and check whether nm+m2+12 is an integer.
 */

def consecutiveNumbersSum(N: Int): Int = {
  val n = N.toLong
  val mm = Math.sqrt(n * 2).floor.toLong
  var count = 0

  for(m<- 1L to mm){
    val t = m*(m+1) + 2*n
    if(t % (2*m) == 0) count += 1
  }

  count
}


consecutiveNumbersSum(5)
consecutiveNumbersSum(9)
consecutiveNumbersSum(15)