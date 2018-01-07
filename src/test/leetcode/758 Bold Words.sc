
// Bold Words in String


def boldWords(words: Array[String], S: String): String = {
  val l = S.length
  val bold = Array.fill(l)(false)

  for {
    i <- 1 to l
    k = S.take(i)
    w <- words if k.endsWith(w)
    j <- 0 until w.length
  } bold(i - 1 - j) = true


  //println(bold.toList)
  var bb = false
  val res = (0 until l).map{ i =>
    if(bold(i)){
      if(bb) S(i)
      else {
        bb = true
        "<b>" + S(i)
      }
    } else {
      if(bb) {
        bb = false
        "</b>" + S(i)
      } else S(i)
    }
  }.mkString("")

  if(bb) res+"</b>" else res
}

boldWords(
  Array("ab", "bc"),
  "aabcdabd"
)