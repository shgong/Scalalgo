def frequencySort(s: String) = {
  s.groupBy(identity).toList.map(_._2).sortBy(-_.length).mkString
}
// not work, generation take too long time


frequencySort("cccAbb")