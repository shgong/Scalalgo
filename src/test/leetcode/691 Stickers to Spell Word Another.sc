// how many number of stickers to incorporate target

def minStickers(stickers: Array[String], target: String): Int = {

  def convert(s: String) = s.toCharArray.groupBy(identity).mapValues(_.length)

  // simplify target
  val tar = convert(target)
  println(tar)

  // simplify sticker
  val st = tar.keys.flatMap{k=>
    stickers.map(x=> (x, x.filter(_==k).length)) // str count
      .groupBy(_._2).mapValues(_.map(_._1)) // count str
      .toList.sortBy(_._1).last._2 // most frequent str
  }.toSet.toList.map(x => convert(x).filterKeys(tar.contains))

  var minCount = Integer.MAX_VALUE


  def search(m: Map[Char, Int], count: Int) {
    if (m.isEmpty) minCount = count min minCount
    else {

      // find stickers with most match
      val matches = st.map { cur =>
        cur.map { case (k, v) =>
          if (m.contains(k)) m(k) min v
          else 0
        }.sum
      }

      var res2 = matches.zipWithIndex // match count, id
        .groupBy(_._1) // match count, [ids]
        .toList.sortBy(_._1).takeRight(2) // count, [(count,ids)]


      // greedy top2
      val res =
        if (res2.length == 1) res2(0)._2
        else res2(0)._2 ++ res2(1)._2


      res.filter(_._1 > 0).foreach { case (_, id) =>
        val cur = st(id)
        val mm = collection.mutable.Map(m.toList: _*)

        // remove chars from residual
        for ((k, v) <- cur) {
          if (mm.contains(k)) {
            if (mm(k) > v) mm(k) -= v
            else mm.remove(k)
          }
        }

        // after removal
        search(mm.toMap, count + 1)
      }
    }
  }

  search(tar, 0)
  if (minCount == Integer.MAX_VALUE) -1 else minCount
}


minStickers(
  Array("control","heart","interest","stream","sentence","soil","wonder","them","month","slip","table","miss","boat","speak","figure","no","perhaps","twenty","throw","rich","capital","save","method","store","meant","life","oil","string","song","food","am","who","fat","if","put","path","come","grow","box","great","word","object","stead","common","fresh","the","operate","where","road","mean"), "stoodcrease")