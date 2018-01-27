def calculate(s: String): Int = {
  val t = s.filter(_ != ' ')
  val l = t.length
  var i = 0

  def parseNum(): Long = {
    val start = i
    while (i < l && t(i).isDigit) i += 1
    t.substring(start, i).toLong
  }

  def parseValue(): Long = {
    if (t(i) != '(' && !t(i).isDigit) i += 1
    if (t(i) == '(') {
      i += 1
      val res = parseExpr()
      i += 1
      res
    } else parseNum()
  }

  def parseExpr(): Long = {
    var agg = 0L
    var last = 0L
    var sign = 1L

    while (i < l && t(i) != ')') t(i) match {
      case '+' => agg += last * sign; sign = 1; last = parseValue()
      case '-' => agg += last * sign; sign = -1; last = parseValue()
      case '*' => last = last * parseValue()
      case '/' => last = last / parseValue()
      case _ => last = parseValue()
    }
    agg + last * sign
  }

  parseExpr().toInt
}


calculate("1+2+3")
calculate(" 6-4 / 2 ")
calculate("2*(5+5*2)/3+(6/2+8)")
calculate("(2+6* 3+5- (3*14/7+2)*5)+3")