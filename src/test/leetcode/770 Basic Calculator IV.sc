// Basic Calculator IV

def basicCalculatorIV(expression: String, evalvars: Array[String], evalints: Array[Int]): List[String] = {

}

case class Expr()


def calculate(s: String): Int = {
  var i = 0
  val ss = s.filter(_!=' ') // remove space
  val l = ss.length

  def parseNumber(): Int = {
    val start = i
    while (i < l && ss(i).isDigit) i += 1
    ss.substring(start, i).toInt
  }

  def parseExpr(): Expr = {
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