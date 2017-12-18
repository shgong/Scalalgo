def countCornerRectangles(grid: Array[Array[Int]]): Int = {
  var res = 0
  val h = grid.length
  if(h<2) return 0
  val w = grid(0).length
  if(w<2) return 0

  for(i<-0 until h; j<-i+1 until h){
    val c = (0 until w).count(x=> grid(i)(x)==1 && grid(j)(x)==1 )
    res += c*(c-1)/2
  }

  res
}

val r = Array(
  Array(1,1,1),
  Array(1,1,1),
  Array(1,1,1)
)

countCornerRectangles(r)