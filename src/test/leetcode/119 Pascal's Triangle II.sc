// k th row of pascal triangle

def getRow(rowIndex: Int): List[Int] = {
  var x = List(1)
  for(i<- 0 until rowIndex) x = (x:+0) zip (0+:x) map (x=> x._1 + x._2)
  x
}

getRow(3)