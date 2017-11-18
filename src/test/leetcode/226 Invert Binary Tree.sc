
case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def invertTree(root: TreeNode): TreeNode = {
  if(root==null) return null

  val left = root.left
  val right = root.right

  root.left = invertTree(right)
  root.right = invertTree(left)

  root
}