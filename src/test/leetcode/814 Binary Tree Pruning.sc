// 814. Binary Tree Pruning
/*
We are given the head node root of a binary tree,
every node's value is either a 0 or a 1.

Return the same tree where every subtree not containing a 1 has been removed.
 */

case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)
def pruneTree(root: TreeNode): TreeNode = {
  def remove(t: TreeNode):Boolean = {
    if(t == null) return false

    val l = remove(t.left)
    if(!l) t.left = null

    val r = remove(t.right)
    if(!r) t.right = null

    if(t.value == 1) return true
    l || r
  }

  remove(root)
  root
}


val t = TreeNode(0, TreeNode(1), TreeNode(0, TreeNode(0)))
pruneTree(t)