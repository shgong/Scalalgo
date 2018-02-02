/*

The string "PAYPALISHIRING" is written in a zigzag pattern

P   A   H   N
A P L S I I G
Y   I   R
 */

def convert(s: String, numRows: Int): String = {
  val l = s.length
  if(numRows==1 || numRows >= l) return s

  val L = Array.fill(numRows)("")
  var index = 0
  var step = 1

  for(c<-s){
    L(index) += c
    if(index==0) step = 1
    else if(index==numRows-1) step = -1
    index += step
  }
  L.mkString
}

convert("PAYPALISHIRING",3)