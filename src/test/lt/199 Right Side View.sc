// rightSideView

class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object Solution {
  def rightSideView(root: TreeNode): List[Int] = {
    if(root==null) return List()

    var level = List(root)
    var rightmost = collection.mutable.ArrayBuffer[Int]()
    while(level.nonEmpty){
      rightmost += level.last.value
      level = level.flatMap(x=>
        if(x.left==null && x.right==null) List()
        else if (x.left==null) List(x.right)
        else if (x.right==null) List(x.left)
        else List(x.left, x.right))
    }
    rightmost.toList
  }


}


// bad data structure given
Some(1) ++ Some(2) // List(1,2)
Some(3) ++ None ++ Some(1) // List(3,1)