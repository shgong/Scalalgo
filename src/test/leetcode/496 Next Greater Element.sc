// Next Greater Element

def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
  val m = collection.mutable.HashMap[Int, Int]()
  val buf = collection.mutable.ArrayBuffer[Int]()

  for(i<-nums2){
    for (j<-buf.indices.reverse) { // reverse, avoid null
      if(buf(j)<i) {
        m(buf(j)) = i
        buf.remove(j)
      }
    }
    buf.append(i)
    println(buf.toList)
  }

  for(i<-buf) m(i) = -1

  nums1.map(m)
}

nextGreaterElement(Array(1,3,5,2,4), Array(6,5,4,3,2,1,7))