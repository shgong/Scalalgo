def romanToInt(s: String): Int = {

  var x = 0
  var last = 0

  val m = Map(
    'M' -> 1000,
    'C' -> 100,
    'D' -> 500,
    'L' -> 50,
    'X' -> 10,
    'V' -> 5,
    'I' -> 1
  )

  for(c<-s){
    val v = m(c)
    if(last>=v){
      x += last
      last = v
    } else {
      last = v - last
    }
  }
  x += last
  x
}

for(i<-List("MCDXXIV")) println(romanToInt(i))