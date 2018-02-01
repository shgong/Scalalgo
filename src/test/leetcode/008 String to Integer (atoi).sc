def myAtoi(str: String): Int = {
  val num = str.dropWhile(_==' ')
  val (negative, n) =
    if(num.startsWith("-")) (true, num.drop(1))
    else if(num.startsWith("+")) (false, num.drop(1))
    else (false, num)

  var r = 0
  var i = 0

  if(n.length==0 || !n(0).isDigit) return 0
  while(i<n.length && n(i).isDigit){
    val tmp = r * 10 + (n(i) - '0')
    // if overflow: negative or can not return
    if(tmp < 0 || (tmp - (n(i)-'0'))/10 != r)
      return if(negative) Integer.MIN_VALUE else Integer.MAX_VALUE
    r = tmp
    i += 1
  }
  if(negative) -r else r
}

myAtoi("   +0 123")
myAtoi("  25")
myAtoi("2147483647")
myAtoi("2147483648")
myAtoi("-56")
myAtoi("-2147483648")
myAtoi("2000000")
myAtoi("0")
myAtoi("-1")
myAtoi("002")