case class TreeNode(value:Int, left:TreeNode, right:TreeNode)

def isSymmetric(root: TreeNode): Boolean = {
  def compare(left:TreeNode, right:TreeNode): Boolean = {
    if(left==null && right==null) true
    else if(left!=null && right!=null){
      left.value == right.value && compare(left.left, right.right) && compare(left.right, right.left)
    }
    else false
  }

  if(root==null)  true
  else compare(root.left, root.right)
}