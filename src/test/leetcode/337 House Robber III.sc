case class TreeNode(value:Int, left:TreeNode = null, right:TreeNode = null)

// max of rob this, max of not rob this
def rob(root: TreeNode): Int = {

  // with, without
  def traverse(node:TreeNode):(Int,Int) = {
    if(node == null) (0,0)
    (0, 0)
  }

  0
}

val t = TreeNode(3, TreeNode(4, TreeNode(1), TreeNode(3)), TreeNode(5, TreeNode(1)))
rob(t)