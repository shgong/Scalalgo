/*
We are given an array A of positive integers,
and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays
the value of the maximum array element in that subarray is
at least L
and at most R.

number of subarrays
 */

def numSubarrayBoundedMax(A: Array[Int], L: Int, R: Int): Int = {
  def comb(x:Int) = x*(x+1)/2

  val l = A.length
  var res = 0
  var nonLComb = 0

  var nonL = 0
  var nonR = 0

  for(a<-A){
    if(a<L) {
      nonL += 1
      nonR += 1
    }
    else if(a<=R){
      nonLComb += comb(nonL)
      nonL = 0
      nonR += 1
    } else if (a>R){
      nonLComb += comb(nonL)
      nonL = 0
      res += comb(nonR) - nonLComb
      nonLComb = 0
      nonR = 0
    }
    println(s"$a: $nonL $nonR $nonLComb $res")
  }

  nonLComb += comb(nonL)
  nonL = 0
  res += comb(nonR) - nonLComb
  nonR = 0
  res
}

numSubarrayBoundedMax(Array(1,2,3,2,1,2,1,3,2,1), 2,2)



/*

112310498109571905810958

R = 8

mark >R
       x   x         x
mark >L <= R
     o        o

For each R-R range
     R11L11111R
     subarrays full - subarrayss without L


 */