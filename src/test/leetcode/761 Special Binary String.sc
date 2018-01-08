// Special Binary String
// 1 = 0
// prefix 1 >= 0


// special property: 1????0
// 1????0 will be concatenation of 1 or more specials
// if one, 1111110000000 already largest
// if more, can sort them into larger specials
// recursive


def makeLargestSpecial(S: String):String = {
  def search(l:Int, r:Int): String =  {
    var cnt = 0
    var prev = l
    val specials = collection.mutable.ArrayBuffer[String]()

    for (i <- l until r) {
      cnt += 2 * S(i) - '1' - '0'
      if (cnt == 0) {
        specials.append(search(prev+1, i))
        prev = i + 1
      }
    }

    specials.sorted.reverse.mkString("1","","0")
  }

  search(0, S.length).slice(1,S.length+1)
}

makeLargestSpecial("110100")

makeLargestSpecial("11011000")