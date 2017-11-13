// small high mid
// find violation, if next element smaller than min or higher than max

def find132pattern(nums: Array[Int]): Boolean = {
  if (nums.length <= 2) return false

  val pair = collection.mutable.ArrayBuffer[(Int, Int)]()

  // keep each max, and the min on the left
  var min = nums(0) min nums(1)
  var max = nums(0) max nums(1)
  if (max == nums(1) && max>min) pair.insert(0, (nums(0), nums(1)))

  for (i <- nums.drop(2)) {

    // if lower appear, update
    if (i < min) min = i
    // if higher appear, update and clear the list
    else {

      if (i > max) {
        max = i
        pair.clear()
      }
      else if (pair.exists { case (a, b) => a < i && b > i }) return true

      // try add or update a pair
      if (pair.isEmpty) {if(i>min) pair.insert(0, (min, i))}
      else if (pair(0)._1 > min && i>min) pair.insert(0, (min, i))
      else if (pair(0)._2 < i) pair(0) = (min, i)
    }
  }
  false
}

find132pattern(Array(3,2,2,1))