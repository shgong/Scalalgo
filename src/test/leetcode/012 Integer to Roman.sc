// 12. Integer to Roman

def intToRoman(num: Int): String = {
  var n = num
  var res = ""
  res +=  "M" * (n / 1000)
  n = n % 1000

  val hundred = n / 100

  if(hundred==9) res += "CM"
  else if(hundred>=5) res += "D" + "C"*(hundred-5)
  else if(hundred==4) res += "CD"
  else res += "C"*hundred

  n = n % 100

  val ten = n / 10
  if(ten == 9) res += "XC"
  else if(ten>=5) res += "L" + "X"*(ten-5)
  else if(ten==4) res += "XL"
  else res += "X"*ten

  n = n % 10

  if(n==9) res += "IX"
  else if(n>=5) res += "V" + "I"*(n-5)
  else if(n==4) res += "IV"
  else res += "I"*n

  res
}