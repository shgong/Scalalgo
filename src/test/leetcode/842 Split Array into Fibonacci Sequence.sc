/*
842. Split Array into Fibonacci Sequence

Given a string S of digits, such as S = "123456579", we can split it into a Fibonacci-like sequence [123, 456, 579].

Formally, a Fibonacci-like sequence is a list F of non-negative integers such that:

0 <= F[i] <= 2^31 - 1, (that is, each integer fits a 32-bit signed integer type);
F.length >= 3;
and F[i] + F[i+1] = F[i+2] for all 0 <= i < F.length - 2.
Also, note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece is the number 0 itself.

Return any Fibonacci-like sequence split from S, or return [] if it cannot be done.
*/

def splitIntoFibonacci(S: String): List[Int] = {
  val l = S.length
  val lf = (l / 3 + 1) min 10

  for (i <- 1 to lf; j <- 1 to lf) {
    val first = S.take(i)
    val second = S.slice(i,i+j)

    if ((first.length==1 || !first.startsWith("0")) &&
      second.length>=1 && (second.length==1 || !second.startsWith("0"))
    ) {
      var n1 = first.toLong
      var n2 = second.toLong
      var n3 = (n1 + n2).toString
      var remain = S.drop(i).drop(j)
      var lst = List[Int](n2.toInt, n1.toInt)

      while ((n1+n2)<=2147483647 && remain.startsWith(n3)) {
        remain = remain.drop(n3.length)
        n1 = n2
        n2 = n3.toLong
        n3 = (n1 + n2).toString
        lst ::= n2.toInt
      }

      if (lst.length>=3 && remain.isEmpty) return lst.reverse
    }
  }

  List()
}


splitIntoFibonacci("123456579")
splitIntoFibonacci("11235813")
splitIntoFibonacci("112358130")
splitIntoFibonacci("17522")
splitIntoFibonacci("1101111")