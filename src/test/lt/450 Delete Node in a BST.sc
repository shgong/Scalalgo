import scala.annotation.tailrec

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

def deleteNode(root: TreeNode, key: Int): TreeNode = {

  var parent: TreeNode = null

  @tailrec
  def find(node: TreeNode, key:Int): TreeNode =  {
    val v = node.value
    if(v==key) node
    else if (v<key ){
      parent = node
      find(node.left, key)
    }
    else {
      parent = node
      find(node.right, key)
    }
  }

  val target: TreeNode = find(root, key)

  val newValue =
    if(target.left==null && target.right==null)  null
    else if(target.left==null) target.right
    else if(target.right==null) target.left
    else {
      // move leftmost of right tree or rightmost of left tree up
      target.left
    }

  if(parent == null) return newValue
  else if (parent.value<target.value) {
    parent.right = newValue
    root
  }
  else {
    parent.left = newValue
    root
  }

}