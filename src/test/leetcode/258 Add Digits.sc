// repeatedly add all its digits until the result has only one digit.
def addDigits(num: Int): Int = {
  var n = num
  while(n>=10) n = n.toString.map(_-'0').sum
  n
}

addDigits(38)