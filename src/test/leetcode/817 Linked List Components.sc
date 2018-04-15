// 817. Linked List Components
/*
We are given head,
the head node of a linked list containing unique integer values.

We are also given the list G,
a subset of the values in the linked list.

Return the number of connected components in G,
where two values are connected
if they appear consecutively in the linked list.
 */

case class ListNode(var next: ListNode = null,
   var x: Int
)

def numComponents(head: ListNode, G: Array[Int]): Int = {
  val m = collection.mutable.HashMap[Int,Int]()

  for(i<-G) m(i) = i

  def assign(i:Int, value:Int):Unit = {
    m(i) = getValue(value)
  }

  def getValue(i:Int):Int = {
    if(m(i)!=i) m(i) = getValue(m(i))
    m(i)
  }

  var last = Integer.MIN_VALUE
  var cur = head
  while(cur!=null){
    if(m.contains(last) && m.contains(cur.x)){
      assign(cur.x, last)
    }
    last = cur.x
    cur = cur.next
  }

  m.values.toSet.toArray.length
}

numComponents(
  ListNode(ListNode(ListNode(ListNode(ListNode(null,3),4),0),2),1),
  Array(3,4,0,2,1)
)