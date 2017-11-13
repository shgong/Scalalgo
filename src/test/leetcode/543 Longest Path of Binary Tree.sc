def diameterOfBinaryTree(root: TreeNode): Int = {

  // (pass, not pass)
  def longest(node: TreeNode): (Int,Int) = {
    if(node.left==null && node.right==null) return (1,1)

    val vl = if(node.left==null) (0,0) else longest(node.left)
    val vr = if(node.right==null) (0,0) else longest(node.right)

    val pass = (vl._1 max vr._1) + 1
    val notpass = vl._2 max vr._2 max (vl._1 + vr._1 + 1)
    (pass, notpass)
  }

  if(root==null) return 0
  val res = longest(root)
  (res._1 max res._2) - 1

}

case class TreeNode(value:Int, left:TreeNode, right:TreeNode)