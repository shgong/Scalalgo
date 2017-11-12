case class TreeNode(
                     var value: Int,
                     var left: TreeNode = null,
                     var right: TreeNode = null
                   )

def buildTreeStack(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
  if (inorder.isEmpty || postorder.isEmpty) return null
  if (inorder.length == 1) return TreeNode(inorder.head)


  val rootValue = postorder.last
  val pos = inorder.zipWithIndex.find(_._1 == rootValue).get._2
  val inorderLeft = inorder.take(pos)
  val inorderRight = inorder.drop(pos + 1)


  val t = new TreeNode(rootValue)
  if (inorderRight.length == 0) {
    t.left = buildTreeStack(inorderLeft, postorder.dropRight(1))
  } else if (inorderLeft.length == 0) {
    t.right = buildTreeStack(inorderRight, postorder.dropRight(1))
  } else {
    val l = inorderLeft.length
    val postorderLeft = postorder.take(l)
    val postorderRight = postorder.drop(l).init

    t.left = buildTreeStack(inorderLeft, postorderLeft)
    t.right = buildTreeStack(inorderRight, postorderRight)
  }
  t
}

// stack overflow

buildTreeStack(Array(1, 2, 3, 4, 5), Array(2,1,5,4,3))