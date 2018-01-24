
case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {

  var res: List[TreeNode] = Nil
  val m = collection.mutable.HashMap[String, Int]()

  def postorder(t:TreeNode): String = {
    if(t==null) return "#"
    val str = postorder(t.left) + "-" + postorder(t.right) + ":" + t.value
    if(m.contains(str) && m(str)==1) res ::= t
    m(str) = m.getOrElse(str, 0) + 1
    str
  }

  postorder(root)
  res
}


findDuplicateSubtrees(
  TreeNode(1,
    TreeNode(2, TreeNode(4)),
    TreeNode(3,
      TreeNode(2, TreeNode(4)),
      TreeNode(4)
    )
  )
)

/*
    1
  2   3
4    2 4
    4

Post order traverse with #
##4
##4#2
##4
##4#2
##4
##4#2##43
##4#2##4#2##431
 */