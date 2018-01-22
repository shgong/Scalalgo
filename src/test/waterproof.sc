case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

def asciiDisplay(root: TreeNode[String]): Seq[String] = {

  def show(level: Int, lastElem: Seq[Boolean], node: TreeNode[String]): Seq[String] =
    (lastElem.init.map(if (_) "  " else "| ").mkString + "+-" + node.data) +: (
      if (node.children.nonEmpty)
        node.children.init.flatMap(show(level + 1, lastElem :+ false, _)) ++:
          show(level + 1, lastElem :+ true, node.children.last)
      else Nil)

  show(0, List(true), root)
}

def asciiDisplay2(root: TreeNode[String]): Seq[String] = {

  def show(level: Int, lastElem: Seq[Boolean], node: TreeNode[String]): Seq[String] =
    (lastElem.init.map(if (_) "  " else "| ").mkString + "+-" + node.data) +: (
      if (node.children.nonEmpty)
        node.children.init.flatMap(show(level + 1, lastElem :+ false, _)) ++:
          show(level + 1, lastElem :+ true, node.children.last)
      else Nil
      )

  show(0, List(true), root)
}

asciiDisplay(TreeNode("Root",
  children = List(
    TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
    TreeNode("level1-2"),
    TreeNode("level1-3")))).foreach(println)