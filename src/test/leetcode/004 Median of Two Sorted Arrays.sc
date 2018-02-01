def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {

  def bSearch(x:Array[Int], start:Int, end:Int, target:Int):Int = {
    var s = start
    var e = end

    while(s<e){
      val mid = (s + e) / 2
      if(x(mid)>target) e = mid
      else s = mid + 1
    }

    s
  }


  var lo = 0
  var lo2 = 0
  var hi = nums1.length - 1
  var hi2 = nums2.length - 1
  val target = (nums1.length + nums2.length - 1) / 2
  var found = false

  while(lo<hi && lo2 < hi2){

    val mid = ( lo + hi ) / 2
    val mid2 = bSearch(nums2, lo2, hi2, nums1(mid))


    println(nums1(lo), nums1(mid),  nums1(hi), nums2(lo2), nums2(mid2), nums2(hi2))

    if(mid + mid2 + 1 < target + 1){
      lo = mid
      lo2 = mid2
    } else {
      hi = mid
      hi2 = mid2
    }

  }

}
// TODO: search 1 in 2, swap, search 2 in 1

findMedianSortedArrays(
  Array(1, 2, 3, 4, 5, 6, 7, 8),
  Array(9, 10, 11, 12, 13)
)

findMedianSortedArrays(Array(1, 2, 2), Array(1, 2, 3))