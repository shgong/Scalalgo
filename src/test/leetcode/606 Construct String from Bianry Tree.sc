
case class TreeNode(var value: Int, var left: TreeNode = null, var right: TreeNode = null)


def tree2str(t: TreeNode): String = {
  if (t == null) return ""
  val l = tree2str(t.left)
  val r = tree2str(t.right)

  if (l == "" && r == "") t.value.toString
  else if(r == "") s"${t.value}($l)"
  else if(l == "") s"${t.value}()($r)"
  else s"${t.value}($l)($r)"
}

tree2str(
  TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3))
)

tree2str(
  TreeNode(1, TreeNode(2, null, TreeNode(4)), TreeNode(3))
)