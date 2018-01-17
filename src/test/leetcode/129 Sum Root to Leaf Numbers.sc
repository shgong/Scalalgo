
case class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)


def sumNumbers(root: TreeNode): Int = {
  def sum(pre: Int, t: TreeNode): Int = {
    if (t == null) return 0
    val cur = pre * 10 + t.value
    val children = sum(cur, t.left) + sum(cur, t.right)
    if (children == 0) cur else children
  }
  sum(0, root)
}

sumNumbers(
  TreeNode(1,
    TreeNode(2),
    TreeNode(3)
  )
)