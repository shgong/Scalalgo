/*
833. Find And Replace in String
replacement operations that replace groups of letters with new ones

Each replacement operation has 3 parameters:
a starting index i,
a source word x
a target word y.

The rule is that if x starts at position i in the original string S,
then we will replace that occurrence of x with y.
If not, we do nothing.

S = "abcd"
replacement operation i = 2, x = "cd", y = "ffff",
"cd" starts at position 2 in the original string S, we will replace it with "ffff".

S = "abcd",
i = 0, x = "ab", y = "eee",
i = 2, x = "ec", y = "ffff",  does nothing

All these operations occur simultaneously.
It's guaranteed that there won't be any overlap in replacement: for example, S = "abc", indexes = [0, 1], sources = ["ab","bc"] is not a valid test case.
 */

def findReplaceString(S: String, indexes: Array[Int], sources: Array[String], targets: Array[String]): String = {
  val l = indexes.length

  var buf = collection.mutable.ArrayBuffer[(Int, Int, String)]()

  for(i<-0 until l){
    val wl = sources(i).length
    if(S.drop(indexes(i)).startsWith(sources(i)))
      buf.append(
        (indexes(i), sources(i).length, targets(i))
      )
  }


  var res = ""
  var i = 0
  val sl = S.length
  buf = buf.sortBy(_._1)
  for((a,b,c)<-buf){
    while(i<sl && i<a) {
      res += S(i)
      i += 1
    }
    i += b
    res += c
  }

  while(i<sl) {
    res += S(i)
    i += 1
  }

  res
}

findReplaceString(
  "vmokgggqzp",
  Array(3,5,1),
  Array("kg","ggq","mo"),
  Array("s","so","bfr")
)

findReplaceString(
  "abcd",
  Array(0,2),
  Array("ab","ec"),
  Array("eee","ffff")
)