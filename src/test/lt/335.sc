def isSelfCrossing(x: Array[Int]): Boolean = {

  val q = collection.mutable.ArrayBuffer[Int]()

  for(i<-x) {
    q.insert(0, i)
    if(q.length>6) q.remove(6)

    //println(q)
    if((q.length>=4 && q(0)>=q(2) && q(1)<=q(3)) ||
      (q.length>=5 && q(1)==q(3) && q(0)+q(4)>=q(2)) ||
      (q.length>=6 && q(0)<q(2) && q(4)<q(2) && q(1)<q(3) && q(5)<q(3) && q(1)+q(5)>=q(3) && q(0)+q(4)>=q(2))) return true
  }
  return false
}

isSelfCrossing(Array(3,3,3,2,1,1))

/*
collision case 4,5,6
 */