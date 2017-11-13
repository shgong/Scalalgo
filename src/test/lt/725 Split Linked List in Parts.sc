case class ListNode(var x: Int = 0, var next: ListNode = null)

object Solution {
  def splitListToParts(root: ListNode, k: Int): Array[ListNode] = {
    var l = 0
    var t = root

    while (t != null) {
      t = t.next
      l += 1
    }

    val a = l / k
    val b = l % k
    val segments = List.fill(b)(a + 1) ++ List.fill(k - b)(a)

    var last: ListNode = null
    var start: ListNode = root
    val result: List[ListNode] = segments.map { n =>
      if (last != null) last.next = null

      if (n == 0) null
      else {

        val current: ListNode = start
        var t = start
        (0 until n - 1).foreach(_ => t = t.next)
        last = t
        if (t.next != null) start = t.next
        current
      }
    }

    result.toArray
  }
}

val test = ListNode(1, ListNode(2, ListNode(3, ListNode(4, null))))
Solution.splitListToParts(test, 5)