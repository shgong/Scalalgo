// Smaller numbers on the right =>
//      right jump to left when sort


def countSmaller(nums: Array[Int]): List[Int] = {
  val l = nums.length
  val smaller = Array.fill(l)(0)

  def sort(part: Array[(Int, Int)]): Array[(Int, Int)] = {
    val half = part.length / 2
    if (half > 0) {
      val left = collection.mutable.Stack(sort(part.take(half)).reverse:_*)
      val right = collection.mutable.Stack(sort(part.drop(half)).reverse:_*)

      for (i <- part.indices.reverse) {
        if (left.nonEmpty && right.nonEmpty && left.top._1>right.top._1){
          smaller(left.top._2) += right.length
          part(i) = left.pop()
        } else if(right.nonEmpty) part(i) = right.pop()
        else part(i) = left.pop()
      }
    }
    part
  }


  val arr = nums.zipWithIndex
  val res = sort(arr)
  println(res.toList)
  smaller.toList
}



countSmaller(Array(5,2,6,1))