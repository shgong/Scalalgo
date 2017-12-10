

case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def findClosestLeaf(root: TreeNode, k: Int): Int = {

  val parent = collection.mutable.HashMap[Int,TreeNode]()


  def find(node:TreeNode): TreeNode = {
      if(node.value==k) return node
      if(node.left!=null) {
        parent(node.left.value) = node
        if(node.left.value==k) return node.left
        val l: TreeNode = find(node.left)
        if(l!=null) return l
      }
      if(node.right!=null) {
        parent(node.right.value) = node
        if(node.right.value==k) return node.right
        val r: TreeNode = find(node.right)
        if(r!=null) return r
      }
      return null
  }

  var begin = find(root)
  if(begin.left==null && begin.right==null) return begin.value

  var start:List[TreeNode] = List(begin).flatMap{n=>
    Option(n.left) ++ Option(n.right)
  }

  var p = begin

  while(start.nonEmpty){
    for(i<-start){
      if(i.left==null && i.right==null) return i.value
    }
    start = start.flatMap{n=>
      Option(n.left) ++ Option(n.right)
    }

    // add sibling
    if(p!=null && parent.contains(p.value)) {
      val next = parent(p.value)
      if(next.left!=null && next.left.value == p.value){
        if(next.right!=null) start = next.right :: start
        p = null
      } else if(next.right!=null && next.right.value == p.value){
        if(next.left!=null) start = next.left :: start
        p = null
      }

    }
  }
  return 0

}


val q = TreeNode(1,TreeNode(2,TreeNode(4,TreeNode(6))), TreeNode(3))
findClosestLeaf(q,2)