// how many number of stickers to incorporate target

def minStickers(stickers: Array[String], target: String): Int = {

  def convert(s:String) = s.toCharArray.groupBy(identity).mapValues(_.length)

  // simplify target
  val tar = convert(target)
  println(tar)

  // simplify sticker, sort by item sticker
  val sta = stickers.map(x=>convert(x).filterKeys(tar.contains)).toSet.toList
  val st = sta.sortBy(x=> -x.values.sum)

  val l = st.length

  var minCount = Integer.MAX_VALUE

  // start search
  def search(item:Int, m: Map[Char,Int], count:Int): Unit = {
    if(m.isEmpty) minCount = minCount min count

    if(item != l){
      val cur = st(item)
      val mm = collection.mutable.Map(m.toList:_*)

      // search sticker
      var copy = 0

      // when cur still contain missing chars
      // when solution can be better thn minCount
      while(mm.filterKeys(cur.contains).nonEmpty && copy<minCount - count - 1){
        // remove chars from residual
        for((k,v)<-cur){
          if(mm.contains(k)){
            if(mm(k)>v) mm(k)-=v
            else mm.remove(k)
          }
        }
        copy+=1
        // after removal
        search(item+1, mm.toMap, count+copy)
      }

      // finally search rest
      // so longer item are always searched first
      search(item+1, m, count)
    }
  }
  search(0, tar, 0)
  if(minCount==Integer.MAX_VALUE) -1 else minCount
}


minStickers(
  Array("divide","danger","student","share","feet","say","expect","chair","special","blue","differ","thank","doctor","top","there","had","ice","mark","note","equate","basic","so","hope","happy","draw","evening","star","shall","thousand","mother","quite","letter","atom","baby","such","trouble","stand","day","room","third","level","salt","thing","shore","truck","block","time","fresh","dream","talk"),"distantcollect")