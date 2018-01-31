// find the starting and ending position of a given target value
def searchRange(nums: Array[Int], target: Int): Array[Int] = {
  var lo = 0
  var hi = nums.length - 1

  if(hi<0 || nums(lo)>target || nums(hi)<target)
    return Array(-1,-1)

  while(lo<hi){
    val mid = (lo+hi)/2
    if(nums(mid)<target) lo = mid + 1
    else hi = mid
  }

  val left = hi
  if(nums(left)!=target) return Array(-1,-1)

  lo = 0
  hi = nums.length

  while(lo<hi){
    val mid = (lo+hi)/2
    if(nums(mid)>target) hi = mid
    else lo = mid + 1
  }

  val right = hi
   Array(left, right - 1)
}

searchRange(Array(5, 7, 7, 8, 8, 8, 10), 8)
searchRange(Array(1), 1)
searchRange(Array(1,2,2,4), 2)