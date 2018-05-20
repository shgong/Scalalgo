/*
838. Push Dominoes

There are N dominoes in a line

In the beginning,
simultaneously push some of the dominoes

When a vertical domino has dominoes falling on it from both sides,
it stays still due to the balance of the forces.

Given a string "S" representing the initial state.
S[i] = 'L', if the i-th domino has been pushed to the left;
S[i] = 'R', if the i-th domino has been pushed to the right;
S[i] = '.', if the i-th domino has not been pushed.

Return a string representing the final state.

Example 1:

Input: ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."

Example 2:

Input: "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.
Note:

0 <= N <= 10^5
String dominoes contains only 'L', 'R' and '.'
 */


def pushDominoes(dominoes: String): String = {

  val ans = ("L" + dominoes + "R").toCharArray
  val len = ans.length

  def calc(l: Int, r: Int): Unit = (ans(r), ans(l)) match {
      case ('L', 'R') =>
        var m = l + 1
        var n = r - 1
        while (m < n) {
          ans(m) = 'R'
          ans(n) = 'L'
          m += 1
          n -= 1
        }
      case ('L', 'L') =>
        for (i <- l + 1 until r) ans(i) = 'L'

      case ('R', 'R') =>
        for (i <- l + 1 until r) ans(i) = 'R'

      case ('R', 'L') =>
    }


  var last = 0
  var i = 1
  while (i < len) {
    if (ans(i) != '.') {
      calc(last, i)
      last = i
    }
    i += 1
  }

  String.valueOf(ans).substring(1, len - 1)
}

pushDominoes(".L.R...LR..L..")
// Output: "LL.RR.LLRRLL.."
pushDominoes("RR.L")
//Output: "RR.L"

