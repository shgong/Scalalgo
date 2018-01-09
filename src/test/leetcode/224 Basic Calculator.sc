def calculate(s: String): Int = {
  var i = 0
  val ss = s.filter(_!=' ') // remove space
  val l = ss.length

  def parseNumber(): Int = {
    val start = i
    while (i < l && ss(i).isDigit) i += 1
    ss.substring(start, i).toInt
  }

  def parseExpr(): Int = {
    var base = 0
    var sign = 1

    while (i < l && ss(i) != ')') {
      if (ss(i) == '-') {
        sign = - 1
        i += 1
      }
      if (ss(i) == '+') {
        sign = 1
        i += 1
      }
      if (ss(i) == '(') {
        i += 1
        base += sign * parseExpr()
      } else base += sign * parseNumber()
    }

    if(i<l && s(i) == ')') i+=1
    base
  }

  parseExpr()
}

calculate("1+1")
calculate("2-1+2")
calculate("(1+(4+5+2)-3)+(6+8)")
calculate("-(12+13)+10")
calculate("(1-3-4-5-6-7)+12")