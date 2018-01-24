/*
A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */

def isHappy(n: Int): Boolean = {
  val set = collection.mutable.Set[Int]()
  var x = n
  while(x!=1){
    if(set.contains(x)) return false
    set += x
    x = x.toString.map(_-'0').map(i=>i*i).sum
  }
  true
}

isHappy(19)
isHappy(2)