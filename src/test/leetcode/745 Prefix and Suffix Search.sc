class WordFilter(_words: Array[String]) {

  import collection.mutable.HashMap
  case class Letter(a: Char, m: HashMap[Char, Letter], var ls: List[Int])

  val prefixRoot = Letter('0', HashMap[Char,Letter](), Nil)
  val suffixRoot = Letter('0', HashMap[Char,Letter](), Nil)

  for (x <- 0 until _words.length) {
    val w = _words(x)

    var i:Letter = prefixRoot
    for(c<-w){
      if(i.m.contains(c)) i = i.m(c)
      else {
        i.m(c) = Letter(c, HashMap[Char,Letter](), Nil)
        i = i.m(c)
      }
    }
    i.ls = x :: i.ls

    i = suffixRoot
    for(c<-w.reverse){
      if(i.m.contains(c)) i = i.m(c)
      else {
        i.m(c) = Letter(c, HashMap[Char,Letter](), Nil)
        i = i.m(c)
      }
    }
    i.ls = x :: i.ls
  }

  println(prefixRoot)
  println(suffixRoot)


  def getWords(l:Letter):List[Int] = {
    l.ls ++ l.m.values.flatMap{x=>getWords(x)}
  }

  def f(prefix: String, suffix: String): Int = {
    var i = prefixRoot
    for(c<-prefix){
      if(!i.m.contains(c)) return -1
      else i = i.m(c)
    }
    val w1 = getWords(i)


    i = suffixRoot
    for(c<-suffix.reverse){
      if(!i.m.contains(c)) return -1
      else i = i.m(c)
    }

    val w2 = getWords(i)

   w1.intersect(w2).max

  }

}


val p = new  WordFilter(Array("hello", "world"))
p.f("h","o")