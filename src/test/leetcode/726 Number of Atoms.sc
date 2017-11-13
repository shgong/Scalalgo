
import collection.mutable.Map

def countOfAtoms(formula: String): String = {
  val n = formula.length
  val s = formula
  var i = 0

  def parseFormula(): Map[String, Int] = {
    val counts = Map[String, Int]()
    while (i < n && s(i) != ')') merge(counts, parseUnits(), 1)
    counts
  }

  def parseUnits(): Map[String, Int] = {
    val counts = Map[String, Int]()
    if (s(i) == '(') {
      i += 1
      val cnts = parseFormula()
      i += 1
      merge(counts, cnts, parseDigits())
    } else {
      val i0 = i
      i += 1
      while (i < n && s(i).isLower) i += 1
      val atom = s.substring(i0, i)
      val digits = parseDigits()

      if(counts.contains(atom)) counts(atom) += digits
      else counts(atom) = digits
    }
    counts
  }

  // get digit, if not found return 1
  def parseDigits(): Int = {
    val i1 = i
    while (i < n && s(i).isDigit) i += 1
    if (i == i1) 1 else s.substring(i1, i).toInt
  }

  // merge util
  def merge(map1: Map[String, Int], map2: Map[String, Int], x: Int): Unit =
    for ((k, v) <- map2)
      if(map1.contains(k))  map1(k) += v * x  else map1(k) = v*x

  parseFormula().toList.sortBy(_._1).map{case(k,v)=>
      k + (if(v==1)"" else v.toString)
  }.mkString
}

countOfAtoms("(H2O)2KCN3")