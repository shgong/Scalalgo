/*
828. Unique Letter String

A character that occur once
for example, UNIQ("LETTER") =  2.

Given a string S, calculate the sum of UNIQ(substring)
over all non-empty substrings of S.

If there are two or more equal substrings at different positions in S,
we consider them different.

Since the answer can be very large, retrun the answer modulo 10 ^ 9 + 7.
 */

def uniqueLetterString(S: String): Int = {
  val letters = S.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2))
  var res: Long = 0
  val l = S.length

  val MOD = 1000000007

  for((c, v) <- letters){
    (-1+:v:+l).sliding(3).foreach { case Vector(x,y,z) =>
        res = (res + (y - x) * (z - y)) % MOD
    }
  }

  res.toInt
}

uniqueLetterString("ABA")
uniqueLetterString("ABC")