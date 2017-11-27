// Parse Lisp Expression

def evaluate(expression: String): Int = {
  var i = 0
  var s = expression
  val n = expression.length


  def readSymbol():String = {
    while(i<n && s(i)==' ') i+=1
    val sb:StringBuilder = new StringBuilder("")
    while(i<n && s(i)!=' ' && s(i)!=')') {sb+=s(i); i+=1; }
    sb.toString()
  }

  def readDigit():Int = {
    while(i<n && s(i)==' ') i+=1
    val sb:StringBuilder = new StringBuilder("")
    while(i<n && s(i)!=' ' && s(i)!=')') {sb+=s(i); i+=1; }
    sb.toString.toInt
  }

  def parseFormula(mm:Map[String,Int]): Int = {
    while(i<n && s(i)==' ') i+=1
    if(i<n &&  s(i)!='(') {
      println(mm.toList)
      if(s(i).isDigit || s(i)=='-') return readDigit()
      else return  mm(readSymbol())
    }

    i += 1

    val res = readSymbol() match {
      case "add" =>
        var counts = 0
        while (i < n && s(i) != ')') counts += parseFormula(mm)
        counts

      case "let" =>
        var m = collection.mutable.HashMap[String, Int](mm.toList:_*)

        var tag = true
        while (i < n && tag) {

          var start = i
          try {
            println(s.drop(i))
            val k = readSymbol()
            if(s(i)==')') throw new Exception()
            i += 1
            val v = parseFormula(m.toMap)
            i += 1
            m(k) = v
          } catch {
            case e:Exception=>
              tag = false
              i = start
          }

          if(s(i)=='(') tag = false
        }
        parseFormula(m.toMap)

      case "mult" =>
        var counts = 1
        while (i < n && s(i) != ')') counts *= parseFormula(mm)
        counts

      case  x =>
        println(x)
        1
    }

    i+=1 // )
    res
  }


  parseFormula(Map[String,Int]())
}


evaluate("(let x9 -2 (mult -7 (mult -35 -3)))")