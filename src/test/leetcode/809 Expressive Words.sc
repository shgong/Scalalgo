// 809. Expressive Words

def expressiveWords(S: String, words: Array[String]): Int = {
  val l =  S.length

  var i = 0


  var ls = List[(Char, Int)]()

  while(i<l){
    var r = 1
    while(i<l-1 && S(i)==S(i+1)) {
      r += 1
      i += 1
    }
    ls ::= (S(i), r)
    i+= 1
  }


  words.count { w =>
    var j = 0
    var m = w.length

    var cs = List[(Char, Int)]()

    while(j<m){
      var r = 1
      while(j<m-1 && w(j)==w(j+1)) {
        r += 1
        j += 1
      }
      cs ::= (w(j), r)
      j+= 1
    }


    if(cs.length != ls.length) false
    else {
      cs.zip(ls).forall { case (c1, c2) =>
        c1._1 == c2._1 &&
          (c1._2 == c2._2 || c2._2>=3 && c1._2<c2._2)
      }
    }
  }

}

val S = "heeellooo"
val words = Array("hello", "hi", "helo")

expressiveWords(S, words)