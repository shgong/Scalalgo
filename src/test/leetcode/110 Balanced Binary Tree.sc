
case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

//  wrong, does not need global balance
def isBalancedWrong(root: TreeNode): Boolean = {
  if(root==null) return true

  var t = List(root)
  var count = 1
  var lastrow = false

  while(t.nonEmpty){
    if(t.length != count) {
      if(lastrow) return false
      else lastrow = true
    }
    t = t.flatMap{case a=> Option(a.left)++Option(a.right)}
    count = 2 * count
  }
  true
}

def isBalanced(root: TreeNode): Boolean = {
  def height(node:TreeNode):Int = {
    if(node==null) return 0

    val lH = height(node.left)
    val rH = height(node.right)

    if(lH == -1 || rH == -1) -1
    else if(lH-rH < -1 || lH-rH > 1)  -1
    else Math.max(lH,rH)+1
  }

  height(root) != -1
}