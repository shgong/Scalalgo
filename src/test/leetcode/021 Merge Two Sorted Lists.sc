 class ListNode(var _x: Int = 0) {
     var next: ListNode = null
     var x: Int = _x
   }

def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
  var x = l1
  var y = l2
  if(x==null) return l2
  if(y==null) return l1

  val res = if(x.x<=y.x) x else y

  if(res.x==x.x) x = x.next
  else y = y.next

  var front = res

  while(x!=null && y!=null){
    if(x.x<=y.x) {
      front.next = x
      front = x
      x = x.next
    } else {
      front.next = y
      front = y
      y = y.next
    }
  }

  while(x!=null ){
      front.next = x
      front = x
      x = x.next
  }

  while(y!=null ){
      front.next = y
      front = y
      y = y.next
  }

  res
}