
case class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)


/*
* Split BST into half based on value
* keep relative order
* */


def splitBST(root: TreeNode, V: Int): Array[TreeNode] = {


  def split(t: TreeNode): Array[TreeNode] = {
    if (t == null) return Array[TreeNode](null, null)

    // put this node into halves based on value
    if (t.value <= V) {
      // if smaller, keep all left, iterate on right
      val res = split(t.right)
      t.right = res(0)
      res(0) = t
      res
    } else {
      // if larger, keep all right, iterate on left
      val res = split(t.left)
      t.left = res(1)
      res(1) = t
      res
    }
  }

  split(root)
}