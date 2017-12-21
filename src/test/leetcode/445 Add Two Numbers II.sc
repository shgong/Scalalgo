
case class ListNode(var x: Int, var next: ListNode = null)

def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
  var p1 = l1
  var p2 = l2
  val s1 = collection.mutable.Stack[Int]()
  val s2 = collection.mutable.Stack[Int]()
  while(p1!=null){s1.push(p1.x); p1=p1.next }
  while(p2!=null){s2.push(p2.x); p2=p2.next }

  var last = 0
  var pre: ListNode = null

  while(s1.nonEmpty || s2.nonEmpty){
    val v1 = if(s1.isEmpty) 0 else s1.pop()
    val v2 = if(s2.isEmpty) 0 else s2.pop()
    var v = v1 + v2 + last
    if(v>=10) {v-=10; last = 1}
    else last = 0

    pre = ListNode(v, pre)
  }

  if(last==1) pre = ListNode(1, pre)
  pre
}

val l1 = ListNode(9, ListNode(1))
val l2 = ListNode(9)
addTwoNumbers(l1, l2)