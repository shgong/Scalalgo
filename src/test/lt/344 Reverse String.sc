def reverseString(s: String): String = s.reverse



def reverseString2(s: String): String = {
  val l = s.length
  var j = l - 1
  val arr = new Array[Char](l)
  for(i<- 0 until l) {arr(i) = s.charAt(j); j-=1}
  arr.mkString
}

reverseString("helloWorld")
