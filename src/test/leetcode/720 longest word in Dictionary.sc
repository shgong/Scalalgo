import scala.collection.mutable.ArrayBuffer

def longestWord(words: Array[String]): String = {
  val w = words.sorted
  val stack = ArrayBuffer[String]("")
  var len = 0
  var word = ""

  for(i<-w){
    println(stack.toList)
    while(stack(0).length >= i.length)
      stack.remove(0)

    if(stack(0) == i.dropRight(1)){
      stack.insert(0, i)
      if(i.length>len) {
        len = i.length
        word = i
      }
    }
  }
  word
}


val w = Array("a", "banana", "app", "appl", "ap", "apply", "apple")

longestWord(w)