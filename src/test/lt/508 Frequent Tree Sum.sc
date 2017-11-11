// findFrequentTreeSum
class TreeNode(var _value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

def findFrequentTreeSum(root: TreeNode): Array[Int] = {

  if (root == null) return Array()

  val sums = collection.mutable.ArrayBuffer[Int]()

  def traverse(t: TreeNode): Int = {
    var sum = t.value
    if (t.left != null) sum += traverse(t.left)
    if (t.right != null) sum += traverse(t.right)
    sums += sum
    sum
  }

  traverse(root)

  sums.groupBy(identity).mapValues(_.size) // sum count
    .groupBy(_._2).mapValues(_.keys) // count [sum]
    .maxBy(_._1)._2.toArray // [sum]
}
