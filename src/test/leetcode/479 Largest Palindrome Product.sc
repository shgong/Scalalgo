/*
Find the largest palindrome made from the product of two n-digit numbers.
you should return the largest palindrome mod 1337.

Input: 2
Output: 987
Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
 */

def largestPalindrome(n: Int): Int = {
  // if input is 1 then max is 9
  if(n == 1) return 9

  // if n = 3 then upperBound = 999 and lowerBound = 99
  val upperBound = Math.pow(10, n) - 1
  val lowerBound = upperBound / 10
  val maxNumber = upperBound.toLong * upperBound.toLong

  // represents the first half of the maximum assumed palindrom.
  // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
  var firstHalf = (maxNumber / Math.pow(10, n).toLong).toInt


  while (firstHalf > lowerBound) {
    // creates maximum palindrom available
    val palindrom = (firstHalf.toString + firstHalf.toString.reverse).toLong

    // search for factors
    var i = upperBound.toLong
    while(i > lowerBound) {
      // if n= 3 none of the factor of palindrom
      // can be more than 999 or less than square root of assumed palindrom
      if (palindrom / i > maxNumber || i * i < palindrom) i = lowerBound.toLong
      // if two factors found
      else if (palindrom % i == 0) return (palindrom % 1337).toInt
      i-=1
    }

    firstHalf -= 1
  }

  -1
}

for(i<-1 to 8) println(largestPalindrome(i))
