/*
 longest common prefix string amongst an array of strings.
 */

def longestCommonPrefix(strs: Array[String]): String = {
  if(strs.length==0) return ""
  if(strs.length==1) return strs.head

  val minLength = strs.map(_.length).min

  for(i<-0 until minLength){
    val c = strs.head(i)
    if(strs.exists(_(i)!=c)) return strs.head.take(i)
  }

  return strs.head.take(minLength)
}