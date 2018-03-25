val code = Array(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")

def uniqueMorseRepresentations(words: Array[String]): Int = {
  val codes = words.map(_.flatMap(x=>code(x-'a')))
  codes.toSet.toList.length
}

uniqueMorseRepresentations(Array("gin", "zen", "gig", "msg"))