// Sentence Similarity

def areSentencesSimilar(words1: Array[String], words2: Array[String], pairs: Array[Array[String]]): Boolean = {
  val l = words1.length
  if(words2.length != l) return false

  val set = collection.mutable.HashSet(pairs.map(_.toList):_*)
  for(i<-0 until l){
    val a = words1(i)
    val b = words2(i)
    if(a == b  || set.contains(List(a,b)) || set.contains(List(b,a))) ()
    else return false
  }
  return true
}

val words1 = Array("great","acting","skills")
val words2 = Array("fine","piaint","talent")
val pairs = Array(Array("great", "fine"), Array("acting","drama"), Array("skills","talent"))





areSentencesSimilar(words1, words2, pairs)