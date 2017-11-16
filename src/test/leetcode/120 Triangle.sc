def minimumTotal(triangle: List[List[Int]]): Int = {
  var m = triangle.last.toArray
  var m2 = m.clone()
  for (list<-triangle.reverse.drop(1)){
    list.indices.foreach{ i =>
      m2(i) = list(i) + math.min(m(i), m(i+1))
    }
    val tmp = m; m = m2; m2 = tmp
  }
  m(0)
}


val q = List(
  List(2),
  List(3,4),
  List(6,5,7),
  List(4,1,8,3)
)

minimumTotal(q)