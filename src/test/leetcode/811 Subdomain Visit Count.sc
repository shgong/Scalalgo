//811. Subdomain Visit Count

def subdomainVisits(cpdomains: Array[String]): List[String] = {

  val m = collection.mutable.Map[String, Int]()

  cpdomains.foreach { s =>

    val tokens = s.split(' ')
    val c = tokens(0).toInt
    val dots = tokens(1).split('.')

    if (dots.length == 2) {
      m(dots(1)) = m.getOrElse(dots(1), 0) + c
      m(tokens(1)) = m.getOrElse(tokens(1), 0) + c
    } else {
      m(dots(2)) = m.getOrElse(dots(2), 0) + c
      m(tokens(1)) = m.getOrElse(tokens(1), 0) + c
      m(dots(1) + "." + dots(2)) = m.getOrElse(dots(1) + "." + dots(2), 0) + c
    }

  }

  m.map { case (k, v) => v + " " + k }.toList
}

subdomainVisits(
  Array("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")
)