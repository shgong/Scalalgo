case class TreeNode(
                     var value: Int,
                     var left: TreeNode = null,
                     var right: TreeNode = null
                   )

// make post order mutable, remove only when building
def buildTree(inorder:Array[Int], postorder:Array[Int]): TreeNode = {
  var post = postorder

  def build(in:Array[Int]): TreeNode = {
    if (in.isEmpty||post.isEmpty) return null
    val root = new TreeNode(post.last)
    post = post.dropRight(1)
    val inorderIndex:Int = in.zipWithIndex.find(_._1 == root.value).get._2
    root.right = build(in.drop(inorderIndex+1))
    root.left = build(in.take(inorderIndex))
    root
  }
  build(inorder)
}
  


buildTree(Array(2,1,3), Array(2,3,1))