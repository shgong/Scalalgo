// Partition Labels
// so that each letter appears in at most one part
// return a list of integers representing the sizes

def partitionLabels(S: String): List[Int] = {
  val first = Array.fill(27)(-1)
  val last = Array.fill(27)(-1)

  for(i<-0 until S.length){
    val c = S(i) - 'a'
    if(first(c) == -1){
      first(c) = i
      last(c) = i
    } else last(c) = i
  }

  val tups = first.zip(last).filter(_._1 != -1).sorted
  var res:List[Int] = List()

  var pre = tups(0)

  //println(tups.toList)
  for(i<- tups){
    if(i._1>pre._2) {
      res = (pre._2 - pre._1 + 1) :: res
      pre = i
    } else {
      pre = (pre._1 min i._1, pre._2 max i._2)
    }
  }
  res = (pre._2 - pre._1 + 1) :: res

  res.reverse
}


partitionLabels("s")
partitionLabels("ababcbacadefegdehijhklij")