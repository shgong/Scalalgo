def generate(numRows: Int): List[List[Int]] = {
  if(numRows==0) return Nil

  var x = List(1)
  var res = List(x)
  for(i<- 1 until numRows) {
    x = (x:+0) zip (0+:x) map (x=> x._1 + x._2)
    res = res :+ x
  }
  res
}

generate(3)