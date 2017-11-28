
/*
 longest substring with most K distinct characters
 constraint: most K chars
*/

def TwoDistinctChar(s: String, k:Int): Int = {

  var (i, j, count) = (0, 0, collection.mutable.HashMap(('A' to 'Z').map((_, 0)): _*))

  while (j < s.length) {
    count(s(j)) += 1
    j += 1
    if (count.values.count(_>0) > k) {
      count(s(i)) -= 1
      i += 1
    }
  }

  j - i // window length increase only, won't decrease
}

TwoDistinctChar("ABAB",2)
TwoDistinctChar("AABAACEEC",1)
TwoDistinctChar("AABAACEEC",2)
TwoDistinctChar("AABAACEEC",3)
TwoDistinctChar("AABAACEEC",4)


