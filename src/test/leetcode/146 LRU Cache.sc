class LRUCache(capacity: Int) {

  case class Node(var key: Int, var value: Int, var pre: Node = null, var next: Node = null)

  val map = collection.mutable.HashMap[Int, Node]()
  val head = Node(0, 0, null, null)
  val tail = Node(0, 0, null, null)
  head.next = tail
  tail.pre = head
  var count = 0

  def deleteNode(node: Node): Unit = {
    node.pre.next = node.next
    node.next.pre = node.pre
  }

  def addToHead(node: Node): Unit = {
    node.next = head.next
    node.next.pre = node
    node.pre = head
    head.next = node
  }

  def get(key: Int): Int = if (map.contains(key)) {
    val node = map(key)
    val result = node.value
    deleteNode(node)
    addToHead(node)
    result
  } else -1

  def put(key: Int, value: Int):Unit = if(map.contains(key)) {
    val node = map(key)
    node.value = value
    deleteNode(node)
    addToHead(node)
  } else {
    val node = Node(key, value)
    map.put(key, node)

    if(count < capacity) {
      count += 1
      addToHead(node)
    } else {
      map.remove(tail.pre.key)
      deleteNode(tail.pre)
      addToHead(node)
    }
  }

}

/**
  * Your LRUCache object will be instantiated and called as such:
  * var obj = new LRUCache(capacity)
  * var param_1 = obj.get(key)
  * obj.put(key,value)
  */