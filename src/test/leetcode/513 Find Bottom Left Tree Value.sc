case class TreeNode(
                     var value: Int,
                     var left: TreeNode = null,
                     var right: TreeNode = null
                   )

def findBottomLeftValue(root: TreeNode): Int = {

  def find(node:TreeNode, depth:Int):(Int,Int) = {
    if(node == null) (0, 0) // lowest depth, won't be picked
    else if(node.left==null && node.right==null) (node.value, depth+1)
    else {
      val left = find(node.left, depth+1)  // will check nullity next recursion
      val right = find(node.right, depth+1)
      if(right._2>left._2) right else left // right only if right deeper
    }
  }

  find(root,0)._1
}

