def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {

  val lp = licensePlate.filter(_.isLetter).map(_.toLower).groupBy(identity).mapValues(_.length)

  for(w<-words.sortBy(_.length)){
    val m = w.groupBy(identity).mapValues(_.length)
    if(lp.forall{case(c,t)=> m.contains(c) && m(c)>=t }) return w
  }

  ""
}

shortestCompletingWord("1lljd", Array("jdlls"))

