case class TreeNode(value:Int, left:TreeNode = null, right:TreeNode = null)

// max of rob this, max of not rob this
def rob(root: TreeNode): Int = {

  // with, without
  def traverse(node:TreeNode):(Int,Int) = {
    if(node == null) return (0,0)

    val (lwith, lwithout) = traverse(node.left)
    val (rwith, rwithout) = traverse(node.right)
    (node.value + lwithout + rwithout, (lwith max lwithout) + (rwith max rwithout))
  }

  val (rootwith, rootwithout) = traverse(root)
  rootwith max rootwithout
}

val t = TreeNode(4, TreeNode(4, TreeNode(1), TreeNode(3)), TreeNode(5, TreeNode(1)))
rob(t)