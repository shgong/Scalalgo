case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def levelOrderBottom(root: TreeNode): List[List[Int]] = {
  if(root==null) return Nil
  var nodes = List(root)
  var res = List[List[Int]]()
  while(nodes.nonEmpty){
    res = nodes.map(_.value) :: res
    nodes = nodes.flatMap{n=> Option(n.left)++Option(n.right)}
  }
  res
}

levelOrderBottom(TreeNode(3,TreeNode(9), TreeNode(20, TreeNode(15))))