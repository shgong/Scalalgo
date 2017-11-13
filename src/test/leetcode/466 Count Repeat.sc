import scala.collection.mutable.ArrayBuffer
// Find max s2*n2 inside s1*n1

def getMaxRepetitions(s1: String, n1: Int, s2: String, n2: Int): Int = {
  // detection matching sequence
  val s11 = s1.filter(s2.toCharArray.contains)
  if(s2.exists(x=> !s1.contains(x))) return 0
  var r1 = 0
  var i = 0
  var j = 0

  // index of s1 when matched a s2
  val repeats = ArrayBuffer[Int](0)
  val list = ArrayBuffer[Int](0)
  var loop = true
  while(loop){
    if(s11(i) == s2(j)){

      i+=1
      if(i==s11.length) {i = 0; r1+=1}

      j+=1
      if(j==s2.length) {
        j = 0
        if(list.contains(i)) loop = false
        list.append(i)
        repeats.append(r1)
      }
    }
    else {
      i+=1
      if(i==s11.length) {i = 0; r1+=1}
    }
  }

  // find last element's previous occurence
  val end = list.length - 1
  val start = list.zipWithIndex.find(_._1 == list(end)).get._2

  // find enter loop and loop length
  val start1 = repeats(start)
  val end1 = repeats(end)
  println(s"${repeats.toList} ${list.toList}")


  // problem: start may be in the middle of s1
  // can not simply regard them as a whole
  var k = (n1 - start1) / (end1 - start1)
  if(k<0) k=0
  val loopCounts = k * (end - start)
  val remain = n1 - k * (end1 - start1)
  println(s"k:$k loopCount:$loopCounts remain:$remain")

  val startCounts =
    if(remain==0) 0
    else repeats.zipWithIndex.filter(_._1 < remain).last._2
  (loopCounts + startCounts) / n2
}


getMaxRepetitions("ab",4,"ab",2)
getMaxRepetitions("aaa",3,"aa",1)
getMaxRepetitions("a", 1, "a", 1)
getMaxRepetitions("nlllnll" , 2, "lnl" ,1)