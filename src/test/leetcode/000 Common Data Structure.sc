case class Tree(value:Int, left:TreeNode, right:TreeNode)

case class TreeNode(var value:Int, var left:TreeNode = null, var right:TreeNode = null)




// [[12,26],[70,85],[55,67],[2,13],[3,18],[91,100],[13,26],[17,27],[41,55],[15,26],[50,68],[34,52],[95,100],[23,33],[89,100],[27,43],[80,95],[97,100],[28,47],[45,58],[76,93],[56,75],[91,100],[61,77],[36,49],[18,32],[96,100],[96,100],[67,86],[46,64],[95,100],[17,35],[8,27],[4,14],[30,43],[74,89],[77,95],[98,100],[31,41],[35,53]]

val str = "[[12,26],[70,85],[55,67],[2,13],[3,18],[91,100],[13,26],[17,27],[41,55],[15,26],[50,68],[34,52],[95,100],[23,33],[89,100],[27,43],[80,95],[97,100],[28,47],[45,58],[76,93],[56,75],[91,100],[61,77],[36,49],[18,32],[96,100],[96,100],[67,86],[46,64],[95,100],[17,35],[8,27],[4,14],[30,43],[74,89],[77,95],[98,100],[31,41],[35,53]]"
str.drop(1).dropRight(1).split("],\\[").map{x=>
  val Array(a,b) = x.split(",")
  (a,b)
}.toList