// Number of Lines To Write String
def numberOfLines(widths: Array[Int], S: String): Array[Int] = {
  var lines = 0
  var current = 100

  if(S.isEmpty) return Array(0,0)

  for(i<-S){
    val w = widths(i - 'a')
    if(current + w>100){
      lines += 1
      current = w
    } else {
      current += w
    }
  }

  Array(lines, current)
}

var widths = Array(10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10)
var S = "abcdefghijklmnopqrstuvwxyz"
numberOfLines(widths, S)


widths = Array(4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10)
S = "bbbcccdddaaa"
numberOfLines(widths, S)

numberOfLines(widths, "")