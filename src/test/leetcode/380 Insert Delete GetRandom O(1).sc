class RandomizedSet() {

  /** Initialize your data structure here. */
  val buf = collection.mutable.ArrayBuffer[Int]()
  val m = collection.mutable.HashMap[Int, Int]()

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  def insert(v: Int): Boolean = {
    if (m.contains(v)) false
    else {
      m(v) = buf.length
      buf.append(v)
      true
    }
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  def remove(v: Int): Boolean = {
    if (!m.contains(v)) return false
    val pos = m(v)
    if (pos != buf.length - 1) {
      m(buf.last) = pos
      buf(pos) =  buf.last
    }
    buf.remove(buf.length - 1)
    m.remove(v)
    true
  }

  /** Get a random element from the set. */
  def getRandom(): Int = buf(scala.util.Random.nextInt(buf.length))
}
var obj = new RandomizedSet()


obj.insert(3)
obj.insert(-2)
obj.remove(2)
obj.insert(1)
obj.insert(-3)
obj.insert(-2)
obj.remove(-2)
obj.remove(3)
obj.insert(-1)
obj.remove(-3)
obj.insert(1)
obj.insert(-2)
obj.insert(-2)
obj.insert(-2)
obj.insert(1)
obj.getRandom()
obj.insert(-2)
obj.remove(0)
obj.insert(-3)
obj.insert(1)