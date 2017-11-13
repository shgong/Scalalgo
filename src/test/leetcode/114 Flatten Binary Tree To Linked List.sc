class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}


def flatten(root: TreeNode): Unit = {
  if (root==null) return
  var last: TreeNode = null

  def traverse(t: TreeNode): Unit = {
    val left = Option(t.left)
    val right = Option(t.right)

    if(last != null){
      last.left = null
      last.right = t
    }
    last = t

    if(left.nonEmpty) traverse(left.get)
    if(right.nonEmpty) traverse(right.get)
  }

  traverse(root)

}