def searchInsert(nums: Array[Int], target: Int): Int = {
  var lo = 0
  var hi = nums.length
  while(lo<hi){
    val mid = (lo + hi) / 2
    if(nums(mid)<target) lo = mid + 1
    else hi = mid
  }
  hi
}

searchInsert(Array(1,3,5,6), 7)
searchInsert(Array(1,3,5,6), 5)
searchInsert(Array(1,3,5,6), 2)
searchInsert(Array(1,3,5,6), 0)