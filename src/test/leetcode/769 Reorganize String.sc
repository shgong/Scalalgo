// Reorganize String
/*
Given a string S,
check if the letters can be rearranged
so that two characters that are adjacent to each other are not the same.

If possible, output a possible result.
If not possible, return the empty string.
 */

def reorganizeString(S: String): String = {
  val l = S.length
  val m = S.groupBy(identity)
  val maxChar = m.mapValues(_.length).maxBy(_._2)._2
  val rest = l - maxChar
  if(l==0 || maxChar>rest+1) return ""

  var res1 = ""
  var res2 = ""
  val limit1 = (l+1)/2
  val limit2 = (l-1)/2



  for(seq <- m.toList.sortBy(-_._2.length)){
    val ls = seq._2.length
    val l1 = res1.length
    if(l1 + ls <= limit1) res1 += seq._2
    else {
      res1 += seq._2.take(limit1 - l1)
      res2 += seq._2.drop(limit1 - l1)
    }
  }

  val res = Array.fill(l)(' ')
  for(i<-0 until l){
    if(i%2==0) res(i) = res1(i/2)
    else res(i) = res2(i/2)
  }
  res.mkString("")
}

reorganizeString("aaab")
reorganizeString("aab")