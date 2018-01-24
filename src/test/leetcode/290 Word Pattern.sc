/*
Given a pattern and a string str, find if str follows the same pattern.

pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
 */

def wordPattern(pattern: String, str: String): Boolean = {
  val m = collection.mutable.HashMap[Char, String]()

  val words = str.split(" ")
  if (pattern.length != words.length) return false

  for ((p, s) <- pattern zip words) {
    if (m.contains(p) && m(p) != s) return false
    else m(p) = s
  }

  // no collision in map
  m.values.groupBy(identity).mapValues(_.size).values.forall(_ == 1)
}