
case class ListNode(var x: Int, var next: ListNode = null)

def insertionSortList(head: ListNode): ListNode = {

  var origin = head
  var result: ListNode = null

  while(origin != null){
    val toInsert = origin
    origin = origin.next

    var p = result
    if(p == null || p.x > toInsert.x){
      toInsert.next = p
      result = toInsert
    } else {
      while(p.next != null && p.next.x < toInsert.x ) p = p.next
      toInsert.next = p.next
      p.next = toInsert
    }
  }

  result
}

insertionSortList(
  ListNode(1,ListNode(19,ListNode(6, ListNode(-5, ListNode(22)))))
)