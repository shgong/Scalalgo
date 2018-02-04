// 776. Split BST


/*
split the tree into two subtrees where one subtree has nodes that are all smaller or equal to
while the other subtree has all nodes that are greater than the target value
<=
>

 */
case class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)


def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
  if (inorder.isEmpty || postorder.isEmpty) return null
  if (inorder.length == 1) return TreeNode(inorder.head)


  val rootValue = postorder.last
  val pos = inorder.zipWithIndex.find(_._1 == rootValue).get._2
  val inorderLeft = inorder.take(pos)
  val inorderRight = inorder.drop(pos + 1)


  if (inorderRight.length == 0) {
    val t = new TreeNode(rootValue)
    t.left = buildTree(inorderLeft, postorder.dropRight(1))
    t
  } else if (inorderLeft.length == 0) {
    val t = new TreeNode(rootValue)
    t.right = buildTree(inorderRight, postorder.dropRight(1))
    t
  } else {
    val l = inorderLeft.length
    val postorderLeft = postorder.take(l)
    val postorderRight = postorder.drop(l).init

    val t = new TreeNode(rootValue)
    t.left = buildTree(inorderLeft, postorderLeft)
    t.right = buildTree(inorderRight, postorderRight)
    t
  }
}

def splitBST(root: TreeNode, V: Int): Array[TreeNode] = {
  // find splitting node

  var listpost:List[Int] = List()
  var listin:List[Int] = List()

  def find(t:TreeNode) : Unit = {
    if(t==null) return ()
    find(t.left)
    listin = t.value :: listin
    find(t.right)
    listpost = t.value :: listpost
  }

  find(root)

  val post = listpost.reverse.toArray
  val in = listin.reverse.toArray


  val leftp = post.filter(_<=V)
  val lefti = in.filter(_<=V)
  val rightp = post.filter(_>V)
  val righti = in.filter(_>V)

  val left = buildTree(lefti, leftp)
  val right = buildTree(righti, rightp)

  Array(left,right)
}

val t = TreeNode(4,
  TreeNode(2,
    TreeNode(1),
    TreeNode(3)
  ),
  TreeNode(6,
    TreeNode(5),
    TreeNode(7)
  )
)

splitBST(t, 2)