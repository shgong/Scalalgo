
case class ListNode(var x: Int, var next: ListNode = null)

def rotateRight(head: ListNode, k: Int): ListNode = {
  var i = head
  if(head == null) return null

  // count length, form circle
  var len = 1
  while(i.next!=null){
    i = i.next
    len += 1
  }
  i.next = head


  // find breaking point
  var toRotate = -k
  while(toRotate<0) toRotate += len

  while(toRotate>0){
    i = i.next
    toRotate -= 1
  }

  val headnew = i.next
  i.next = null
  headnew
}


rotateRight(
  ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5))))),
  2
)
rotateRight(
  ListNode(1, ListNode(2)),
  2
)
rotateRight(
  ListNode(1, ListNode(2)),
  5
)