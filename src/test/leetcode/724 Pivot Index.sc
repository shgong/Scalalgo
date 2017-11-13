object Solution {
  def pivotIndex(nums: Array[Int]): Int = {
    val l = nums.length
    if(l<3) return -1

    var rights = nums.sum - nums(0)
    var lefts = nums(0)
    for (i<- 1 to l-2){
      val pivot = nums(i)
      if(lefts == rights - pivot) return i
      lefts += pivot
      rights -= pivot
    }

    return -1
  }
}