/*
Letter Case Permutation

Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */

def letterCasePermutation(S: String): List[String] = {

  var res = List[String]()

  def dfs(pre:String, next:String):Unit = {
    if(next.isEmpty) res ::= pre
    else {
      val c = next.head
      if(c.isLetter){
        dfs(pre + c.toUpper, next.tail)
        dfs(pre + c.toLower, next.tail)
      } else dfs(pre+c, next.tail)
    }
  }

  dfs("", S)
  res
}

letterCasePermutation("12345")
letterCasePermutation("3z4")
letterCasePermutation("a1b2")