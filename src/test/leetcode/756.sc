// Pyramid Transition Matrix

// allowed use only once
def pyramidTransitionWrong(bottom: String, allowed: List[String]): Boolean = {

  def iterate(allowed: Set[String], left: String, next: String): Boolean = {
    if (left.length <= 1) {
      generate_status(allowed, next)
    } else {
      for (i <- allowed.filter(_.startsWith(left.take(2)))) {
        if (iterate(allowed - i, left.drop(1), next + i.last)) return true
      }
      false
    }
  }

  def generate_status(allowed: Set[String], bottom: String): Boolean = {
    println(allowed)
    println(bottom)

    if (bottom.length == 1) true
    else iterate(allowed, bottom, "")
  }

  generate_status(allowed.toSet, bottom)
}

def pyramidTransition(bottom: String, allowed: List[String]): Boolean = {

  val hm: Map[String, List[String]] = allowed.groupBy(_.take(2)).mapValues(_.map(_.drop(2)))
  val impossible = collection.mutable.Set[String]()

  def iterate(left: String, next: String): Boolean = {
    if (left.length <= 1) generate_status(next)
    else {
      val toMatch = left.take(2)

      if (hm.contains(toMatch)) hm(toMatch).foreach { i =>
        if (next.isEmpty || hm.contains(next.takeRight(1) + i))
          if (iterate(left.drop(1), next + i)) return true
      }

      false
    }
  }

  def generate_status(bottom: String): Boolean = {
    println(bottom)

    if (bottom.length == 1) true
    else if (impossible.contains(bottom)) false
    else {
      val res = iterate(bottom, "")
      impossible.add(bottom)
      res
    }
  }

  generate_status(bottom)
}

pyramidTransition("ABDBACAAAC",
  List("ACC", "AAC", "AAB", "BCB", "BAD", "CAC", "CCD", "CAA", "CCB", "DAD", "ACD", "DCB", "ABB", "BDA", "BDC", "BDB", "BBD", "BBC", "BBB", "ADB", "ADC", "DDC", "DDB", "CDD", "CBC", "CBA", "CBD", "CDC", "DBC"))