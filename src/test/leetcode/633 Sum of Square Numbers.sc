def judgeSquareSum(c: Int): Boolean = {

  val k:Int = math.floor(math.sqrt(c)).toInt
  val s = collection.mutable.HashSet[Int]()

  for(i<-0 to k){
    val sq = i * i
    s += sq
    if(s.contains(c-sq)) return true
  }
  false
}

for(i<-1 to 25) println(f"$i%-4d" + judgeSquareSum(i))