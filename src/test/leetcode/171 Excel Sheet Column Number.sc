def titleToNumber(s: String): Int = {
  var i = 0
  s.foreach{ c =>
    val k = c - 'A'
    i *= 26
    i += k + 1
  }
  i
}

for(i<-List("A","Z","AA","AB")) println(titleToNumber(i))