
//  not allowed to use the operator + and -

// try math
def getSum1(a: Int, b: Int): Int = {
  Math.log(Math.pow(Math.E, a) * Math.pow(Math.E,b)).toInt
}

/*
2147483647
-2147483648
WRONG ANSWER, 0, -1
 */


// bit
def getSum(a: Int, b: Int): Int = {
  if(b==0) a else getSum(a ^ b, (a & b) << 1)
}

// a = 11001
// b = 01110
// a ^ b = 11111
// a & b = 01000 => need carry

getSum(11,67)