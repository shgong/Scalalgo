case class ListNode(var x: Int = 0, var next: ListNode = null)


def reorderList(head: ListNode): Unit = {

  if(head==null || head.next==null) return

  // find split point
  var fast = head
  var slow = head

  while (fast != null && fast.next != null) {
    slow = slow.next
    fast = fast.next.next
  }
  val middle = slow.next
  slow.next = null



  // reverse second list
  var last: ListNode = null
  var cur = middle

  while (cur != null) {
    val tmp = cur.next
    cur.next = last
    last = cur
    cur = tmp
  }

  // now merge head and last
  var prev = head
  var a = head.next
  var b = last

  // add a,b to prev in turn
  while(b!=null){
    prev.next = b
    prev = b
    b = b.next
    if(a!=null){
      val tmp = a
      a = b
      b = tmp
    }
  }
}


val q = ListNode(1, ListNode(2, ListNode(3, ListNode(4, null))))
reorderList(q)
q