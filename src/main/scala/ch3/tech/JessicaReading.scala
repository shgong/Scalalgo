package ch3.tech

// P page book with topic a_i on page i
// read continuous pages to cover all topics
// find the minimum continuous pages required

object JessicaReading {
  def solve(a: Array[Int]) = {
    val count = collection.mutable.Map(a.map((_, 0)).toSeq: _*)
    val pages = a.length
    val topics = count.size

    var (s, t, num) = (0, 0, 0)
    var res = pages

    while (t < pages && num < topics) {
      if (count(a(t)) == 0) {
        t += 1
        count(a(t)) += 1
        num += 1
      }
    }

    while (num >= topics) {
      res = math.min(res, t - s)
      if (count(a(s)) == 0) {
        s += 1
        count(a(s)) -= 1
        num -= 1
      }

      while (t < pages && num < topics) {
        if (count(a(t)) == 0) {
          t += 1
          count(a(t)) += 1
          num += 1
        }
      }

      res
    }

  }
}
