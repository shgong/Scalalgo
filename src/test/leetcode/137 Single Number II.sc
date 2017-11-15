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
  val m = collection.mutable.HashMap[Int,Int]()
  nums.foreach{i=>
    if(!m.contains(i)) m(i)=2
    else if (m(i)==2) m(i)=1
    else m.remove(i)
  }
  m.keys.head
}



0 ^ 15

0^15 & ~(0^15)