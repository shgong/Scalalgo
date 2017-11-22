// the third maximum distinct number

import collection.Searching._
def thirdMax(nums: Array[Int]): Int = {
  var m = collection.mutable.ArrayBuffer[Int]()

  for(i<-nums){
    m.search(i) match {
      case Found(_) =>
      case InsertionPoint(x) =>
        m.insert(x, i)
        if(m.length>3) m.remove(0)
    }
  }
  if(m.length==3) m(0) else m.last
}





val test = Array(1,2)
thirdMax(test)