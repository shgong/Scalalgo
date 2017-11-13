def generateParenthesis(n: Int): List[String] = {

  val t = collection.mutable.ArrayBuffer[String]()

  def loop(start:String, n:Int, open:Int) {
    if(n==0) t.append(start + ")" * open)
    else {
      if(open>0) loop(start+")", n, open-1)
      loop(start+"(", n-1, open+1)
    }
  }

  loop("", n, 0)
  t.toList
}

def generateParenthesis(n: Int, open:Int=0): List[String] = {
  if(n>0) generateParenthesis(n-1, open+1).map("("+_) ++
    (if(open>0) generateParenthesis(n, open-1).map(")"+_) else Nil)
  else List(")"*open)
}

