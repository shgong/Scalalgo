/*
 return whether the four points could construct a square.
 */

def validSquare(p1: Array[Int], p2: Array[Int], p3: Array[Int], p4: Array[Int]): Boolean = {
  val points = List(p1,p2,p3,p4).map{case Array(x,y)=>(x,y)}.sorted
  def sqdis(a:(Int,Int), b:(Int,Int)):Int =
    (b._2 - a._2)*(b._2 - a._2) + (b._1 - a._1)*(b._1 - a._1)

  val l = sqdis(points(0),points(1))
  if(l==0) return false

  sqdis(points(0),points(2)) == l &&
    sqdis(points(2),points(3)) == l &&
    sqdis(points(1),points(3)) == l &&
    (points(2)._2 - points(0)._2) * (points(1)._2 - points(0)._2) +
      (points(1)._1 - points(0)._1) * (points(2)._1 - points(0)._1) == 0
  // dot product
}


validSquare(
  Array(0,0), Array(1,1), Array(1,0), Array(0,1)
)