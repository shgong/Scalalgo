def findContentChildren(g: Array[Int], s: Array[Int]): Int = {
  val child = g.sorted
  val cookie = s.sorted

  var i = 0
  val l = cookie.length
  var satisfied = 0

  for(c<-child) {
    while(i<l && cookie(i)<c) i += 1
    if(i<l) {
      satisfied += 1
      i += 1
    } else return satisfied
  }

  satisfied
}


findContentChildren(Array(1,2), Array(1,2,3))