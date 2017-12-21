def addBinary(a: String, b: String): String = {

  val ar = a.reverse
  val br = b.reverse
  var i = 0
  var last = 0
  var res = ""

  while (i < ar.length || i < br.length) {
    val v1 = if (i < ar.length) ar(i) - '0' else 0
    val v2 = if (i < br.length) br(i) - '0' else 0
    var v = v1 + v2 + last
    if (v >= 2) {
      v -= 2
      last = 1
    } else last = 0
    res += v
    i += 1
  }
  if (last == 1) res += "1"
  res.reverse
}

addBinary("1", "11")