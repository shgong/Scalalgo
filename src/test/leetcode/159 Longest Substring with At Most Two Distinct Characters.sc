
/*
 longest substring with most substring with K distinct characte
 constraint: most K chars
*/

def TwoDistinctChar(s: String): Int = {

  var (i, j, count) = (0, 0, collection.mutable.HashMap(('A' to 'Z').map((_, 0)): _*))

  while (j < s.length) {
    count(s(j)) += 1
    j += 1
    if (count.values.count(_>0) > 2) {
      count(s(i)) -= 1
      i += 1
    }
  }

  j - i // window length increase only, won't decrease
}

TwoDistinctChar("ABAB")
TwoDistinctChar("AABABBA")
TwoDistinctChar("AABAACEEC")

