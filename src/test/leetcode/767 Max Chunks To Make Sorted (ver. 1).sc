// 767. Max Chunks To Make Sorted (ver. 1)

def maxChunksToSorted(arr: Array[Int]): Int = {
  val l = arr.length

  var chunk = 0

  var reset = true

  var minId = 0
  var maxId = 0
  var minV = Integer.MAX_VALUE
  var maxV = Integer.MIN_VALUE


  for(i<- 0 until l){
    val c = arr(i)

    if(reset){
      minId = i
      maxId = i
      minV = c
      maxV = c
      reset = false
    } else {
      maxId = i
      minV = minV min c
      maxV = maxV max c
      reset = false
    }

    if(minId == minV && maxId == maxV ){
      chunk += 1
      reset = true
    }
  }

  chunk
}

maxChunksToSorted(Array(4,3,2,1,0))
maxChunksToSorted(Array(1,0,2,3,4))