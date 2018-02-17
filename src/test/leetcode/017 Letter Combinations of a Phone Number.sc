/*
2-abc
3-def
4-ghi
5-jkl
6-mno
7-pqrs
8-tuv
9-wxyz
 */

def letterCombinations(digits: String): List[String] = {

  val m = Map(
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz"
  )


  var res = List[String]()

  if(digits.isEmpty) return res

  def dfs(s:String, next:String): Unit = {
    if(next=="") res = s :: res
    else {
      for(i<-m(next.head)){
        dfs(s+i, next.tail)
      }
    }
  }

  dfs("", digits)
  res
}

letterCombinations("23")