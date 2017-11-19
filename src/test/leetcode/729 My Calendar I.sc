class MyCalendar {

  val k = collection.mutable.ArrayBuffer[(Int,Int)]()

  // intersect, or within
  def book(i: Int, j: Int): Boolean = {
    if(k.isEmpty) {
      k.append((i,j))
      true
    }
    else {
      if(k(0)._1>=j) {
        k.insert(0, (i,j))
        return true
      }
      else if(k.last._2<=i) {
        k.append((i,j))
        return true
      }

      for(r<-0 until k.length-1){
        if(k(r)._2<=i && k(r+1)._1>=j) {
          k.insert(r+1, (i,j))
          return true
        }
      }

      return false
    }

  }
}

var obj = new MyCalendar()

for(i <- List(
  (47,50),(33,41),(39,45),(33,42),(25,32),(26,35),(19,25),(3,8),(8,13),(18,27)
)) println(obj.book(i._1, i._2))
