def restoreIpAddresses(s: String): List[String] = {

  val m = collection.mutable.ArrayBuffer[String]()

  def getIp(pre: String, s: String, n: Int): Unit = {
      if (n == 0) {
        if (s=="") m.append(pre.drop(1))
      } else {
        if (s.length >= 3 && s.take(3).toInt <= 255 && s.take(3).toInt>99)
          getIp(pre + "." + s.take(3), s.drop(3), n - 1)
        if (s.length >= 2 && s.take(2).toInt > 9)
          getIp(pre + "." + s.take(2), s.drop(2), n - 1)
        if (s.length >= 1)
          getIp(pre + "." + s(0), s.drop(1), n - 1)
      }
  }

  getIp("", s, 4)
  m.toList
}
restoreIpAddresses("0000")