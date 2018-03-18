def similarRGB(color: String): String = {

  var res = "#"

  def toHex(a:Int):Char = {
    if(a<=9) (a+'0').toChar
    else (a+'a'-10).toChar
  }

  def toIn(a:Char):Int = {
    if(a<='9') a-'0'
    else a-'a'+10
  }


  for (i <- 1 to 5 by 2) {
    val a = toIn(color(i))
    val b = toIn(color(i + 1))

    val shorthand =
      if (b == a) a
      else if (b < a) {
        val cur = 16 * a + b
        val last = 16 * (a - 1) + (a - 1)
        val next = 16 * a + a
        if (cur - last <= next - cur) a - 1 else a
      } else {
        val cur = 16 * a + b
        val last = 16 * (a) + (a)
        val next = 16 * (a + 1) + (a + 1)
        if (cur - last <= next - cur) a else a + 1
      }

    res += toHex(shorthand)
    res += toHex(shorthand)
  }
  res
}

val q = "#71c986"
similarRGB(q)
similarRGB("#00ff59")