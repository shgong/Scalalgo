/*
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */

def calculate(s:String):Long = {
  var ev = collection.mutable.ArrayBuffer[String]("")
  var i = 0
  val l = s.length

  // tokenize
  while(i<l){
    if(!s(i).isDigit) ev.insert(0, s(i).toString)
    else if(ev(0)=="" || ev(0)(0).isDigit) ev(0) += s(i)
    else {ev.insert(0, ""); ev(0)+=s(i)}
    i += 1
  }
  ev = ev.reverse
  i = 0

  // Illegal number
  for(i<-0 until ev.length)
    if(ev(i).length>1 && ev(i)(0)=='0') return Long.MinValue

  // Calculate *
  while(i < ev.length){
    if(ev(i) == "*"){
      ev(i-1) = (ev(i-1).toLong * ev(i+1).toLong).toString
      ev.remove(i+1)
      ev.remove(i)
    } else i += 1
  }

  // Calculate + -
  i = 0
  while(i < ev.length){
    if(ev(i) == "+"){
      ev(i-1) = (ev(i-1).toLong + ev(i+1).toLong).toString
      ev.remove(i+1)
      ev.remove(i)
    } else if(ev(i) == "-"){
      ev(i-1) = (ev(i-1).toLong - ev(i+1).toLong).toString
      ev.remove(i+1)
      ev.remove(i)
    } else i += 1
  }
  ev(0).toLong
}

// Search
def addOperators(num: String, target: Int): List[String] = {
  var res = List[String]()
  if(num.isEmpty) return Nil
  def search(n:String, pre:String = ""):Unit = {
    if(n.length == 0) {
      //println(pre)
      if(calculate(pre) == target) res =  pre::res
    } else {
      val cur = n.take(1)
      val next = n.drop(1)
      search(next, pre + cur)
      search(next, pre + "*" + cur)
      search(next, pre + "+" + cur)
      search(next, pre + "-" + cur)
    }
  }

  search(num.drop(1), num.take(1))
  res
}

addOperators("105",5)
