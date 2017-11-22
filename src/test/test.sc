val v = Vector(1,2,3,4)

v :+ 1
1 +: v


List(4,66,1,3,51,123).sortWith{case(i,j)=> i<j}


val k = List(
  ("a",1),
  ("b",99),
  ("d",98),
  ("r",99)
)

k.sorted(
  Ordering.by[(String,Int),(Int,String)](x=> (-x._2, x._1))
)


