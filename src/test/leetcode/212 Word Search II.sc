import scala.collection.concurrent.TrieMap

// find if word exists in the grid from any order, horizon or vertical neighbored
// Given a 2D board and a list of words from the dictionary, find all words in the board.


case class PrefixMap(var m: Map[Char, PrefixMap] = Map.empty, var value: Boolean = false) {
  def empty = new PrefixMap

  def add(s: String): PrefixMap =
    if (s == "") this
    else {
      val leading = s(0)
      m get leading match {
        case None => m = m + (leading -> empty)
        case _ =>
      }
      m(leading) add (s substring 1)
    }

  def remove(s: String): Unit = {
    val leading = s(0)
    if (s.length == 1) {
      m(leading).value = false
      if (m(leading).m.isEmpty && !m(leading).value) m = m - leading
    } else {
      m(leading).remove(s substring 1)
      if (m(leading).m.isEmpty && !m(leading).value) m = m - leading
    }
  }

  def get(s: String): Option[PrefixMap] = {
    if (s == "") Some(this)
    else {
      val leading = s(0)
      if (m.contains(leading)) m(leading) get (s substring 1)
      else None
    }
  }
}


def findWords(board: Array[Array[Char]], words: Array[String]): List[String] = {
  val h = board.length
  if (h == 0) return Nil
  val w = board(0).length

  var res: List[String] = Nil
  val pm = PrefixMap()
  for (w <- words) pm.add(w).value = true

  def search(x: Int, y: Int, prev: String, history: List[(Int, Int)]): Unit = {
    if (x >= 0 && x < h && y >= 0 && y < w && !history.contains((x, y))) {
      val cur: String = prev + board(x)(y)
      if (pm.get(cur).nonEmpty && pm.get(cur).get.value) {
        res = cur :: res
        pm.remove(cur) // try remove if false and empty, faster
      }

      if (pm.get(cur).nonEmpty) {
        search(x + 1, y, cur, (x, y) :: history)
        search(x - 1, y, cur, (x, y) :: history)
        search(x, y + 1, cur, (x, y) :: history)
        search(x, y - 1, cur, (x, y) :: history)
      }
    }
  }
  for (i <- 0 until h; j <- 0 until w) search(i, j, "", Nil)
  res
}

val bd1 = Array("a", "a").map(_.toCharArray)
findWords(bd1, Array("a"))

val board = Array("oaan", "etae", "ihkr", "iflv").map(_.toCharArray)
findWords(board, Array("eat", "pea", "rain", "oath"))

val board2 = Array("seenew", "tmriva", "obsibd", "wmysen", "ltsnsa", "iezlgn").map(_.toCharArray)
val target2 = Array("anda", "anes", "anesis", "avener", "avine", "bena", "bend", "benda", "besa", "besan", "bowl", "daven", "embow", "inerm", "irene", "myst", "nane", "nanes", "neem", "reem", "reest", "renew", "rine", "riva", "rive", "riven", "sand", "sane", "sang", "seen", "seer", "send", "sise", "stob", "stow", "teil", "vine", "viner", "vire", "wadna", "wave", "wene", "wots")

findWords(board2, target2)