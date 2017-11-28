/*
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times.

Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
 */

/*
 longest substring with most substring with K distinct characte
 constraint: most K char which is different from most frequent one
sliding window, check step
*/

def characterReplacement(s: String, k: Int): Int = {

  var (i, j, count) = (0, 0, collection.mutable.HashMap(('A' to 'Z').map((_, 0)): _*))

  while (j < s.length) {
    count(s(j)) += 1
    j += 1
    if (j - i - count.values.max > k) {
      count(s(i)) -= 1
      i += 1
    }
  }

  j - i // window length increase only, won't decrease
}

characterReplacement("ABAB", 2)
characterReplacement("AABABBA", 1)
characterReplacement("AABAACEEC", 1)

