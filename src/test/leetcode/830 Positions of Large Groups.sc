/*
830. Positions of Large Groups
In a string S of lowercase letters,
these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has
the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.
We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.
 */

def largeGroupPositions(S: String): List[List[Int]] = {
  val l = S.length

  var res: List[List[Int]] = Nil
  var start = 0
  var i = 0
  while(i<l){
    start = i
    while(i<l-1 && S(i)==S(i+1)) i+= 1
    if(i-start>=2) res ::= List(start, i)
    i += 1
  }

  res.reverse
}

largeGroupPositions("abcdddeeeeaabbbcd")