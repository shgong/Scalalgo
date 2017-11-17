// Next Greater Element Circular
// can have duplicate
// need track index

def nextGreaterElements(nums: Array[Int]): Array[Int] = {
  val m = nums.clone()
  val buf = collection.mutable.ArrayBuffer[(Int,Int)]()

  for((num, index)<-nums.zipWithIndex){
    while(buf.nonEmpty && buf(0)._1<num) {
        m(buf(0)._2) = num
        buf.remove(0)
    }
    buf.insert(0 , (num, index))
  }

  // next half, no insert
  for((num, index)<-nums.zipWithIndex){
    while(buf.nonEmpty && buf(0)._1<num) {
      m(buf(0)._2) = num
      buf.remove(0)
    }
  }

  for(i<-buf) m(i._2) = -1
  m
}

nextGreaterElements(Array(100,1,11,1,120,111,123,1,-1,-100))