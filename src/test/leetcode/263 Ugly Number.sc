// prime factor only include 2,3,5


def isUgly(num: Int): Boolean = {
  if(num==0) return false

  var s = num
  while((s & 1)==0) s >>= 1
  while(s%3==0) s/=3
  while(s%5==0) s/=5
  s==1
}
isUgly(6)
isUgly(8)
isUgly(14)