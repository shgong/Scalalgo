def addStrings(num1: String, num2: String): String = {
  val res = Array.fill(num1.length+1 max num2.length+1)(0)
  var pos = res.length - 1

  var n1 = num1.reverse
  var n2 = num2.reverse

  var i = 0
  var last = 0

  while(i<res.length){
    val v1 = if(i<n1.length) n1(i)-'0' else 0
    val v2 = if(i<n2.length) n2(i)-'0' else 0
    var v = v1 + v2 + last
    if(v>=10) {v-=10; last=1} else last = 0
    res(i) = v
    i += 1
  }

  val out = res.reverse.dropWhile(_==0).mkString("")
  if(out.isEmpty) "0" else out
}

addStrings("12312","542")