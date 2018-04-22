/*
821. Shortest Distance to a Character
Given a string S and a character C,
return an array of integers representing the shortest distance from
the character C in the string.

Example 1:

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */

def shortestToChar(S: String, C: Char): Array[Int] = {
  val len = S.length
  val dis = Array.fill(len)(Integer.MAX_VALUE)

  for(i<-0 until len if S(i)==C){
    var j = i
    while(j>=0 && i-j<dis(j)) {
      dis(j) = i - j
      j -= 1
    }

    j = i + 1
    while(j<len && j-i<dis(j)) {
      dis(j) = j - i
      j += 1
    }
  }

  dis
}

shortestToChar("loveleetcode", 'e')