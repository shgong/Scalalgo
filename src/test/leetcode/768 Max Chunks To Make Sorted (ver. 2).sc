// 768. Max Chunks To Make Sorted (ver. 2)

def maxChunksToSorted(arr: Array[Int]): Int = {
  val l = arr.length

  var chunk = 0

  var reset = true

  val ref = arr.sorted

  var minId = 0
  var maxId = 0
  var minV = Integer.MAX_VALUE
  var maxV = Integer.MIN_VALUE
  var sumV = 0
  var refsumV = 0


  for(i<- 0 until l){
    val c = arr(i)

    if(reset){
      minId = i
      maxId = i
      minV = c
      maxV = c
      sumV = c
      refsumV = ref(i)
      reset = false
    } else {
      maxId = i
      minV = minV min c
      maxV = maxV max c
      sumV += c
      refsumV += ref(i)
      reset = false
    }

    if(ref(minId) == minV && ref(maxId) == maxV && sumV == refsumV ){
      chunk += 1
      reset = true
    }
  }

  chunk
}

maxChunksToSorted(Array(5,4,3,2,1))
maxChunksToSorted(Array(2,1,3,4,4))
maxChunksToSorted(Array(1,1,0,0,1))