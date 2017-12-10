def networkDelayTime(times: Array[Array[Int]], N: Int, K: Int): Int = {

  val time = Array.fill(N+1)(0)
  val signals = collection.mutable.ArrayBuffer[Array[Int]](
    times:_*)

  var todo = collection.mutable.ArrayBuffer(K)
  time(K) = 1

  while(todo.nonEmpty) {
    val start = todo(0)

    var i = 0
    while(i < signals.length){
      val edge = signals(i)
      if(edge(0) == start) {

        val end = edge(1)
        if(time(end)==0) {
          time(end)= time(start) + edge(2)
          todo.append(end)
        } else if(time(end)> time(start) + edge(2)){
          time(end)= time(start) + edge(2)
        }

        signals.remove(i)
        i-=1
      }
      i+=1
    }

    todo.remove(0)
    todo = todo.sortBy(x=>time(x))
  }


  if(time.drop(1).contains(0)) return -1
  else return time.max - 1
}

networkDelayTime(
  Array(Array(1,2,1),Array(2,3,2),Array(1,3,4)), 3, 1
)