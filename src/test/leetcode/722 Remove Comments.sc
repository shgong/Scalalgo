def removeComments(source: Array[String]): List[String] = {
  var multi = false
  var line = false

  val s = source.mkString("\n")
  val r = new StringBuffer()
  var i = 0

  while (i < s.length) {
    // multi end
    if (multi) {
      if(i < s.length-1 && s(i)=='*' && s(i+1)=='/') {
        multi = false
        i += 2
      } else i+=1
    } else if (line) {
      if(s(i)=='\n') {
        r.append("\n")
        line = false
      }
      i += 1
    } else {
      if(i < s.length-1 && s(i)=='/' && s(i+1)=='*') {
        multi = true
        i += 2
      } else if(i < s.length-1 && s(i)=='/' && s(i+1)=='/')  {
        line = true
        i += 2
      } else {
        r.append(s(i))
        i += 1
      }
    }
  }
  r.toString.split("\n").toList.filter(_.nonEmpty)
}


val source = Array("/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}")

removeComments(source)