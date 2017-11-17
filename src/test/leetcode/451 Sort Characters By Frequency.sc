def frequencySort(s: String) = {
  s.groupBy(identity).toList.map(_._2).sortBy(-_.length).mkString
}
// not work, generation take too long time


def frequencySort2(s: String) = {
  val m = Array.fill(256)(0)
  val sb = new collection.mutable.StringBuilder()

  for(c<-s)m(c.toInt) += 1
  m.zipWithIndex.filter(_._1!=0).sortBy(-_._1).foreach{case(x,y)=>
    for(_<-0 until x) sb.append(y.toChar)
  }
  sb.toString
  // s.groupBy(identity).toList.map(_._2).sortBy(-_.length).mkString
}

frequencySort("cccAbb")