def multiply(num1: String, num2: String): String = {
  val res = Array.fill(num1.length + num2.length)(0)
  var pos = res.length - 1

  for(i<-num1.reverse){
    var tmp = pos
    for(j<- num2.reverse){
      res(tmp) += (i-'0') * (j-'0')
      res(tmp-1) += res(tmp) / 10
      res(tmp) = res(tmp) % 10
      tmp -= 1
    }
    pos -= 1
  }

  val output = res.dropWhile(_==0).mkString("")
  if(output.isEmpty) "0" else output
}

val a = "30"
val b = "10"


multiply(a,b)