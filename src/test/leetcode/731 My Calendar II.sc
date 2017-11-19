class MyCalendarTwo {

  val k = collection.mutable.ArrayBuffer[(Int, Int)]()
  val dk = collection.mutable.ArrayBuffer[(Int, Int)]()


  // insert into double booking segments
  def ins(i: Int, j: Int): Boolean = {
    if (dk.isEmpty) dk.append((i, j))
    else {
      for (r <- 0 until dk.length) {
        if (j <= dk(r)._1) {
          dk.insert(r, (i, j))
          return true
        }
      }
      dk.append((i,j))
    }
    return false
  }

  // check double booking contains
  def checkdb(i: Int, j: Int): Boolean = {
    if (dk.isEmpty) return true
    if (dk(0)._1 >= j) return true
    else if (dk.last._2 <= i) return true

    for (r <- 0 until dk.length - 1) {
      if (dk(r)._2 <= i && dk(r + 1)._1 >= j) {
        return true
      }
    }

    return false
  }

  // intersect, or within, 3 scenario
  def book(i: Int, j: Int): Boolean = {

    if (checkdb(i, j)) {

      var r = 0
      val toInsert = collection.mutable.ArrayBuffer[(Int, Int)]()

      // mutable !!!
      // insert together later
      while (r < k.length) {
        if ((j > k(r)._1 && j <= k(r)._2) ||
          (i >= k(r)._1 && i < k(r)._2) ||
          (i<= k(r)._1 && j>= k(r)._2)) {
          toInsert.append((i max k(r)._1, j min k(r)._2))
        }
        r += 1
      }

      for(i<-toInsert) ins(i._1, i._2)

      k.append((i, j))
      true
    }
    else false

  }

}

var obj = new MyCalendarTwo()

for (i <-
     List( (55,67), (17,27),(50,68), (34,52), (45,58), (56,75), (46,64),  (35,53))
) println(obj.book(i._1, i._2))


