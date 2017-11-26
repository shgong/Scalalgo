/*

Suppose an array sorted in ascending order
rotated at some pivot unknown

i.e.   0 1 2 4 5 6 7
become 4 5 6 7 0 1 2

Find the minimum element.
 */

def findMin(nums: Array[Int]): Int = {
  var (lo, hi) = (0, nums.length-1)

  while(lo<hi){
    val mid = (lo + hi)/2
    if(nums(mid)>nums(hi)) lo = mid + 1
    else hi = mid
  }
  nums(lo)
}

findMin(Array(4,5,6,7,0,1,2,3))