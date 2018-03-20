class RandomizedCollection() {

  val buf = collection.mutable.ArrayBuffer[Int]()
  val m = collection.mutable.HashMap[Int, collection.mutable.Set[Int]]()

  def insert(v: Int): Boolean = {
    val q = !m.contains(v)
    if (!q) m(v) += buf.length else m(v) = collection.mutable.Set(buf.length)
    buf.append(v)
    q
  }

  def remove(v: Int): Boolean = {
    val q = m.contains(v)
    if (q) {
      val pos = m(v).head
      m(v) = m(v).tail

      if (pos != buf.length - 1) {
        val lastElem = buf.last
        m(lastElem) -= buf.length - 1
        m(lastElem) += pos
        buf(pos) = lastElem
      }

      buf.remove(buf.length - 1)
      if (m(v).isEmpty) m.remove(v)
    }
    q
  }

  def getRandom(): Int = buf(scala.util.Random.nextInt(buf.length))

}


var obj = new RandomizedCollection()
obj.insert(1)
obj.insert(1)
obj.insert(2)
obj.insert(2)
obj.insert(2)
obj.remove(1)
obj.remove(1)
obj.remove(2)
obj.insert(1)
obj.remove(2)
for (i <- 0 until 10) println(obj.getRandom())
