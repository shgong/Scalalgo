def toHex(num: Int): String = {
  var n = num
  val res = String.valueOf(
    (1 to 8).toArray.map { i =>
      val c: Char =
        if ((n & 15) <= 9) ('0' + (n & 15)).toChar
        else ('a' - 10 + (n & 15)).toChar
      n >>= 4
      c
    }).reverse.dropWhile(_ == '0')

  if (res.isEmpty) "0" else res
}

toHex(-1)
toHex(26)