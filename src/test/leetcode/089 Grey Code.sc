def grayCode(n: Int): List[Int] = {
  var last = List(0)
  var base = 1

  (1 to n).foreach{ _ =>
    last = last ++ last.reverse.map(base + _)
    base = base << 1
  }

  last
}


// The gray code is a binary numeral system where two successive values differ in only one bit.
// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:


grayCode(2)
grayCode(3)
grayCode(4)