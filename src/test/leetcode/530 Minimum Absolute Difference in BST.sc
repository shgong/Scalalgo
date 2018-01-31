case class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)

def getMinimumDifference(root: TreeNode): Int = {

  // min, max, min diff
  def search(t: TreeNode): (Int, Int, Int) = {
    var min = t.value
    var max = t.value
    var min_dist = Integer.MAX_VALUE

    if (t.left != null) {
      val l = search(t.left)
      min = l._1
      min_dist = min_dist min (t.value - l._2) min l._3
    }

    if (t.right != null) {
      val r = search(t.right)
      max = r._2
      min_dist = min_dist min (r._1 - t.value) min r._3
    }

    (min, max, min_dist)
  }

  search(root)._3
}

getMinimumDifference(
  TreeNode(1, null, TreeNode(4, TreeNode(2)))
)

/*
ANOTHER: BST inorder traversal is sorted, simple compare previous
 */

var min = Integer.MAX_VALUE
var prev: Int = Integer.MAX_VALUE

def traverse(root: TreeNode): Unit = if (root != null) {
  traverse(root.left)
  if (prev != Integer.MAX_VALUE) min = min min (root.value - prev)
  prev = root.value
  traverse(root.right)
}

traverse(TreeNode(1, null, TreeNode(4, TreeNode(2))))
min