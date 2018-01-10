// Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

case class TreeNode(
                     var value: Int,
                     var left: TreeNode = null,
                     var right: TreeNode = null
                   )


def generateTrees(n: Int): List[TreeNode] = {
  if (n == 0) return List()

  def gen(start: Int, end: Int): IndexedSeq[TreeNode] = {
    if (start > end) return IndexedSeq(null)
    for {
      idx <- start to end
      left <- gen(start, idx - 1)
      right <- gen(idx + 1, end)
    } yield TreeNode(idx, left, right)
  }

  gen(1, n).toList
}


generateTrees(2)

/*
{
  val root = new TreeNode(idx)
  root.left = left
  root.right = right
  root
}
*/