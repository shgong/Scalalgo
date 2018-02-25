// Custom Sort String
/*

S and T are strings composed of lowercase letters.

In S, no letter occurs more than once.

S was sorted in some custom order previously.
We want to permute the characters of T so that they match the order that S was sorted.
More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.
 */

def customSortString(S: String, T: String): String = {
  val x = Array.fill(26)(0)
  for(i<-0 until S.length) x(S(i)-'a') = i + 1
  T.sortBy(c => x(c - 'a'))
}

customSortString("cba","abcd")