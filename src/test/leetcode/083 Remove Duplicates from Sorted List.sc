
case class ListNode(var x: Int, var next: ListNode = null)

def deleteDuplicates(head: ListNode): ListNode = {
  if(head==null) return head

  var cur = head

  while(cur.next != null){
    if(cur.next.x == cur.x){
      val tmp = cur.next.next
      cur.next = tmp
    } else {
      cur = cur.next
    }
  }

  head
}

deleteDuplicates(
  ListNode(1,ListNode(1,ListNode(2, ListNode(2, ListNode(4)))))
)