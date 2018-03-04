
def zeroes(x: Long): Long = {
  var count = 0L
  var n = x
  var i = 5L
  while (n / i >= 1) {
    count += n / i
    i *= 5
  }
  count
}

def preimageSizeFZF(K: Int): Int = {
  // find lower bound
  var lo = 0L
  var hi = 10000000000L

  for(i<-0 until 35){
    val mid = (lo + hi) / 2
    if(zeroes(mid)>=K) hi = mid
    else lo = mid
  }

  //println(lo, hi)
  val lb = hi

  lo = 0L
  hi = 10000000000L

  for(i<-0 until 35){
    val mid = (lo + hi) / 2
    if(zeroes(mid)<=K) lo = mid
    else hi = mid
  }
  //println(lo, hi)
  (lo - lb).toInt + 1
}


zeroes(10000000000L)
math.pow(2,32)

for(i<-0 until 50) println(s"$i ${zeroes(i)}")

preimageSizeFZF(0)
preimageSizeFZF(2)
preimageSizeFZF(5)

/*
def findTrailingZeros(n):

    # Initialize result
    count = 0

    # Keep dividing n by
    # powers of 5 and
    # update Count
    i=5
    while (n/i>=1):
        count += n/i
        i *= 5

    return int(count)
 */