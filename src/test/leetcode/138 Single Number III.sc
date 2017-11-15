def singleNumber(nums: Array[Int]): Array[Int] = {
  val m = collection.mutable.Set[Int]()
  nums.foreach{i=>
    if(!m.contains(i)) m += i
    else m.remove(i)
  }
  m.toArray
}

def binary(nums: Array[Int]): Array[Int] = {
  val xor = nums.reduce(_ ^ _)
  val bit = xor & -xor  // last positive bit

  nums.groupBy(x=> (x & bit)>0).values.toArray
    .map(_.reduce(_ ^ _))
}



