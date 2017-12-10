def nextGreatestLetter(letters: Array[Char], target: Char): Char = {

  import collection.Searching._
  val res = letters.search((target.toInt + 1).toChar).insertionPoint
  if(res==letters.length) return letters(0)
  else return letters(res)

}


nextGreatestLetter(Array('a','b','c'), 'z')
nextGreatestLetter(Array('a','b','d'), 'c')
nextGreatestLetter(Array('a','b','c'), 'e')
nextGreatestLetter(Array('a','b','c'), 'a')