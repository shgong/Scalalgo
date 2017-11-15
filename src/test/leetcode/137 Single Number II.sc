def singleNumber(nums: Array[Int]): Int = {
  val m = collection.mutable.HashMap[Int,Int]()
  nums.foreach{i=>
    if(!m.contains(i)) m(i)=2
    else if (m(i)==2) m(i)=1
    else m.remove(i)
  }
  m.keys.head
}

def binary(nums: Array[Int]): Int = {
  var ones = 0
  var twos = 0

  nums.foreach{i=>
    ones = (ones ^ i) & ~twos
    twos = (twos ^ i) & ~ones
  }
  ones
}

/*
First Occurence
ones XOR i, two is empty, keep it
twos XOR i, one is the same, drop it

Second Occurence
ones XOR i, dropped
twos XOR i, one is empty, keep it

Third Occurence
ones XOR i, two is the same, dropped
twos XOR i, dropped
 */

binary(Array(4,4,4,7,7,7,15))