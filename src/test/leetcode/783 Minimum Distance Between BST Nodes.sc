// Minimum Distance Between BST Nodes


case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def minDiffInBST(root: TreeNode): Int = {

  var first = true
  var last: Int = Integer.MAX_VALUE
  var min: Int = Integer.MAX_VALUE

  def search(t:TreeNode): Unit = {
    if(t==null) return()

    if(t.left!=null) search(t.left)

    if(!first){
      min = min min (t.value - last)
    } else first = false

    last = t.value

    if(t.right!=null) search(t.right)
  }

  search(root)
  min
}

minDiffInBST(TreeNode(2, TreeNode(1), TreeNode(3)))