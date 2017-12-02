case class TreeNode(value:Int, left:TreeNode, right:TreeNode)

def isSameTree(p: TreeNode, q: TreeNode): Boolean =
  if(p==null && q==null) true
  else if (p!=null && q!=null) p.value == q.value && isSameTree(p.left, q.left) &&  isSameTree(p.right, q.right)
  else false