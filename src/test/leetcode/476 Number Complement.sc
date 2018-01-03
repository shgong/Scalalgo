// Number Complement

def findComplement(num: Int): Int = {
  var n = num
  var k = 0
  val s = collection.mutable.Stack[Int]()

  // special case when last digit is 1
  while(n!=0){
    s.push(n & 1)
    n >>= 1
  }

  while(s.nonEmpty){
    k <<= 1
    k += 1 - s.pop()
  }

  k
}



findComplement(1)
findComplement(2)
findComplement(3)
findComplement(4)
findComplement(5)
