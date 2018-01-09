// Reverse Polish Nation
// postfix notation

def evalRPN(tokens: Array[String]): Int = {
  val s = collection.mutable.Stack[Int]()

  tokens foreach { token =>
    val t:Int = token match {
      case "+" => s.pop() + s.pop()
      case "-" =>
        val b = s.pop()
        val a = s.pop()
        a - b
      case "*" => s.pop() * s.pop()
      case "/" =>
        val b = s.pop()
        val a = s.pop()
        a / b
      case num => num.toInt
    }
    s.push(t)
  }

  s.pop()
}

evalRPN(Array("2", "1", "+", "3", "*"))
evalRPN(Array("4", "13", "5", "/", "+"))