
def calculate(s: String): Int = {
  var i = 0
  val ss = s.filter(_ != ' ')
  val l = ss.length

  def parseNumber(): Int = {
    while(i<l && !ss(i).isDigit) i+=1
    val start = i
    while (i < l && ss(i).isDigit) i += 1
    ss.substring(start, i).toInt
  }

  var base = 0
  var last = parseNumber()
  // record last + - sign in the numbers
  // calc when next + - sign, or at the end
  while (i < l) {
    ss(i) match {
      case '+' =>
        base = base + last
        last = parseNumber()
      case '-' =>
        base = base + last
        last = -1 *  parseNumber()
      case '*' => last = last * parseNumber()
      case '/' => last = last / parseNumber()
      case _ =>
        i += 1
    }
  }
  base = base + last
  base
}
  calculate("3+2*2")
  calculate("3/2")
  calculate("3+5/2")