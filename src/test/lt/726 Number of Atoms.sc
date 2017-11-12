def countOfAtoms(formula: String): String = {
  var flag = 0
  var buf = collection.mutable.ArrayBuffer[Char]()
  val l = formula.length
  var last = ""
  var m = collection.mutable.HashMap[String, Int]("H"->12)


  for (i<-0 until l-1){
    val c = formula(i)

    if(c.isLetter && c.isUpper && buf.nonEmpty) {
      if(buf(0).isDigit) {
        if(m.contains(last)) m(last)=m(last) + buf.mkString.toInt
        else m(last)=buf.mkString.toInt
        buf.clear
      }
      else if(buf(0).isLetter){
        if(m.contains(last)) m(last)=m(last) + 1
        else m(last)=1
        last = buf.mkString
        buf.clear
      }
    } else if(c.isDigit && buf.nonEmpty && buf(0).isLetter ){
      last = buf.mkString
      buf.clear
    }

    buf.append(c)
    println(buf)
  }

  println(m)

  ""
}


countOfAtoms("H2O")