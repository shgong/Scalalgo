// Convex hull Algorithm

case class Point(var _x: Int, var _y: Int) {
    var x: Int = _x
    var y: Int = _y
}


def outerTrees(points: Array[Point]): List[Point] = {

  val sorted = points.sortBy(_.y).sortBy(_.x)

  // find if cba are clockwise
  // equal ratio can also be removed
  def drive(a:Point, b:Point, c:Point) =
    (c.x - a.x)*(b.y - a.y) < (c.y - a.y)*(b.x - a.x)

  // add a point, try pop up middle points to get upper hull
  val upper = collection.mutable.ArrayBuffer[Point]()
  val lower = collection.mutable.ArrayBuffer[Point]()

  for(i<-sorted){
    upper.insert(0,i)
    while(upper.length>=3 && drive(upper(0),upper(1),upper(2)))
      upper.remove(1)
  }
  println("upper：" + upper)

  for(i<-sorted.reverse){
    lower.insert(0,i)
    while(lower.length>=3 && drive(lower(0),lower(1),lower(2)))
      lower.remove(1)
  }
  println("lower: " + lower)

  (upper ++ lower).toSet.toList
}



outerTrees(
  Array(Point(1,1), Point(2,2), Point(2,0), Point(2,4), Point(3,3), Point(4,2))
)