/*
   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

  can have multiple chars
 */

def singleChar(data: Array[Int]): Boolean = {
  (data.length == 1 && (data(0) >> 7) == 0) ||
    (data.length == 2 && (data(0) >> 5) == 6 && (data(1) >> 6) == 2) ||
    (data.length == 3 && (data(0) >> 4) == 14 && (data(1) >> 6) == 2 && (data(2) >> 6) == 2) ||
    (data.length == 4 && (data(0) >> 3) == 30 && (data(1) >> 6) == 2 && (data(2) >> 6) == 2 && (data(3) >> 6) == 2)
}

def validUtf8(data: Array[Int]): Boolean = {
  var i = 0
  while(i<data.length){
    val c0 = data(i)
    if((c0>>7)==0) {
      i+=1
    } else if((c0>>5)==6) {
      if(i+1>=data.length) return false
      if((data(i+1)>>6)!= 2) return false
      i+=2
    } else if((c0>>4)==14) {
      if(i+2>=data.length) return false
      if((data(i+1)>>6)!= 2) return false
      if((data(i+2)>>6)!= 2) return false
      i+=3
    } else if((c0>>3)==30) {
      if(i+3>=data.length) return false
      if((data(i+1)>>6)!= 2) return false
      if((data(i+2)>>6)!= 2) return false
      if((data(i+3)>>6)!= 2) return false
      i+=4
    } else return false
  }
  return true
}
