//  if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

def hasPathSum(root: TreeNode, sum: Int): Boolean = {
  if (root == null) return false
  val rest = sum - root.value

  root.left == null && root.right == null && rest == 0 ||
    hasPathSum(root.left, rest) ||
    hasPathSum(root.right, rest)
}