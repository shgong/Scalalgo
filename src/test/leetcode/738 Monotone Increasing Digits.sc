/*
Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 */

def monotoneIncreasingDigits(N: Int): Int = {
  // find the last decreasing
  val n = N.toString.toCharArray
  var i = 0
  while(i<n.length-1 && n(i)<=n(i+1)) i+=1
  if(i==n.length-1) return N

  // find left equals
  while(i>0 && n(i-1)==n(i)) i-=1

  // -1 & add 9s
  n(i) = (n(i).toInt - 1).toChar
  for(j<-i+1 until n.length) n(j)='9'
  String.valueOf(n).toInt
}

monotoneIncreasingDigits(10)
monotoneIncreasingDigits(1234)
monotoneIncreasingDigits(332)