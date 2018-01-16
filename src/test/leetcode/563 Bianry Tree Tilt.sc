case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)

def findTilt(root: TreeNode): Int = {

  def tiltsum(t:TreeNode): (Int, Int) = {
    if(t==null) return (0,0)

    val l = tiltsum(t.left)
    val r = tiltsum(t.right)

    val sum = l._2 + r._2 + t.value
    val tilt = l._1 + r._1 + Math.abs(l._2-r._2)
    (tilt,sum)
  }

  tiltsum(root)._1

}