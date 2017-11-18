
case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def addOneRow(root: TreeNode, v: Int, d: Int): TreeNode = {

  if(d==1){
    val t = new TreeNode(v)
    t.left = root
    t
  }
  else if(d==2) {
    if(root.left!=null){
      val tmp = root.left
      root.left = new TreeNode(v)
      root.left.left = tmp
    } else root.left = new TreeNode(v)

    if(root.right!=null){
      val tmp = root.right
      root.right = new TreeNode(v)
      root.right.right = tmp
    } else root.right = new TreeNode(v)
    root
  } else {
    if(root.left!=null)  addOneRow(root.left, v, d-1)
    if(root.right!=null) addOneRow(root.right, v, d-1)
    root
  }
}

val q = TreeNode(4, TreeNode(2), TreeNode(6))

addOneRow(q, 1, 2)