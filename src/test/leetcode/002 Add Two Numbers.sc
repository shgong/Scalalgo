
case class ListNode(var x: Int, var next: ListNode = null)

def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
  var p1 = l1
  var p2 = l2
  var result: ListNode = null
  var pre: ListNode = null
  var last = 0

  while (p1 != null || p2 != null) {

    val v1 = if (p1 != null) p1.x else 0
    val v2 = if (p2 != null) p2.x else 0
    var v = v1 + v2 + last
    if (v >= 10) {
      v -= 10; last = 1
    } else {
      last = 0
    }

    if (result == null) {
      result = new ListNode(v)
      pre = result
    } else {
      pre.next = new ListNode(v)
      pre = pre.next
    }

    if (p1 != null) p1 = p1.next
    if (p2 != null) p2 = p2.next

  }

  if(last == 1) pre.next = new ListNode(1)

  result
}

val l1 = ListNode(9)
val l2 = ListNode(9)
addTwoNumbers(l1, l2)