/*
839. Similar String Groups

Two strings X and Y are similar
if we can swap two letters of X, so that it equals Y.

"tars" and "rats" are similar
"rats" and "arts" are similar,
but "star" is not similar to "tars", "rats", or "arts".

two connected groups by similarity:
{"tars", "rats", "arts"} and {"star"}.
Notice that "tars" and "arts" are in the same group
even though they are not similar.

Formally, each group is such that a word is in the group
if and only if it is similar to at least one other word in the group.

We are given a list A of unique strings.
Every string in A is an anagram of every other string in A.
How many groups are there?

A.length <= 2000
A[i].length <= 1000
A.length * A[i].length <= 20000
 */


// typical Union Find
def numSimilarGroups(A: Array[String]): Int = {
  val len = A.length
  val parent = Array(0 until len: _*)

  def isSimilar(a: String, b: String) = a.zip(b).count(x => x._1 != x._2) == 2
  def union(a: Int, b: Int): Unit = parent(find(a)) = parent(find(b))
  def find(x: Int): Int = {
    if (parent(x) != x) parent(x) = find(parent(x))
    parent(x)
  }

  for (i <- 0 until len; j <- i + 1 until len if find(i) != find(j) && isSimilar(A(i), A(j)))
    union(i, j)

  parent.map(find).toSet.size
}

numSimilarGroups(Array("tars", "rats", "arts", "star"))

/*
class Solution {
public:

    vector<int> parent;



};
 */