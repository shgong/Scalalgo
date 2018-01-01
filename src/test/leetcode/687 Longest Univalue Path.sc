case class TreeNode(
                     var value: Int,
                     var left: TreeNode = null,
                     var right: TreeNode = null
                   )


// longest path -> edges
def longestUnivaluePath(root: TreeNode): Int = {
  var max = 0
  def traverse(node:TreeNode): Int = {
    if(node==null) return 0
    val (lefty, righty) = (traverse(node.left), traverse(node.right))
    val left = if(node.left!=null && node.left.value==node.value) lefty+1 else 0
    val right = if(node.right!=null && node.right.value==node.value) righty+1 else 0
    max = max max (left + right)
    left max right
  }
  traverse(root)
  max
}

