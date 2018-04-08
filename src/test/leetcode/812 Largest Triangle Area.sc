//812. Largest Triangle Area
// Return the area of the largest triangle that can be formed by any 3 of the points.

def largestTriangleArea(points: Array[Array[Int]]): Double = {
  points.combinations(3).map { case Array(a,b,c) =>
    math.abs(0.5 * (a(0)*(b(1)-c(1)) + b(0)*(c(1)-a(1)) + c(0)*(a(1)-b(1))))
  }.max
}

val t = Array(Array(0,0),Array(0,1),Array(1,0),Array(0,2),Array(2,0))
largestTriangleArea(t)
largestTriangleArea(Array(Array(0,0),Array(1,1),Array(2,2)))