def originalDigits(s: String): String = {

  val m = collection.mutable.HashMap(('a' to 'z').map((_, 0)): _*)
  for (i <- s) m(i) += 1

  val c0 = m('z'); for (c <- "zero") m(c) -= c0
  val c2 = m('w'); for (c <- "two") m(c) -= c2
  val c6 = m('x'); for (c <- "six") m(c) -= c6
  val c8 = m('g'); for (c <- "eight") m(c) -= c8
  val c3 = m('h'); for (c <- "three") m(c) -= c3
  val c4 = m('r'); for (c <- "four") m(c) -= c4
  val c5 = m('f'); for (c <- "five") m(c) -= c5
  val c7 = m('s'); for (c <- "seven") m(c) -= c7
  val c1 = m('o'); for (c <- "one") m(c) -= c1
  val c9 = m('i')

  "0" * c0 + "1" * c1 + "2" * c2 + "3" * c3 +
    "4" * c4 + "5" * c5 + "6" * c6 +
    "7" * c7 + "8" * c8 + "9" * c9
}

originalDigits("owoztneoer")
originalDigits("fviefuro")