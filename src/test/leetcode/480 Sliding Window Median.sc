def medianSlidingWindow(nums: Array[Int], k: Int): Array[Double] = {

  val queue = collection.mutable.Queue[Int]()
  val buffer = collection.mutable.ArrayBuffer[Int]()
  var res: List[Double] = Nil
  import collection.Searching._


  for(i<-nums){
    val idx = buffer.search(i).insertionPoint
    buffer.insert(idx, i)
    queue.enqueue(i)
    if(buffer.length>k) {
      val idx = buffer.search(queue.dequeue()).insertionPoint
      buffer.remove(idx)
    }
    if(buffer.length == k){
     if(k % 2 == 1) res ::= buffer(k/2) * 1.0
     else res ::= buffer(k/2) * 0.5 + buffer(k/2-1) * 0.5
    }
  }

  res.reverse.toArray
}

medianSlidingWindow(Array(1,3,-1,-3,5,3,6,7), 3).toList