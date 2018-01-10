def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {


  def find(a:Array[Int], b:Array[Int], target: Int): Int = {
    val la = a.length
    val ma = (la+1)/2
    val lb = b.length
    val mb = (lb+1)/2

    println(s"${a.toList} ${b.toList} $target $ma $mb")

    if(la==0) b(target-1)
    else if(lb==0) a(target-1)
    else if(la+lb<=5) (a ++ b).sorted.apply(target-1)
    else if(a(ma-1)>=b(mb-1)){
      if(target<=mb) find(a.take(ma), b.take(mb), target)
      else if(target>ma + lb) find(a.drop(ma), b.drop(mb), target-ma-mb)
      else find(a.take(ma), b.drop(mb), target-mb)
    } else {
      if(target<=ma) find(a.take(ma), b.take(mb), target)
      else if(target>mb + la) find(a.drop(mb), b.drop(ma), target-mb-ma)
      else find(a.drop(ma), b.take(mb), target-ma)
    }
  }

  val len = nums1.length + nums2.length
  if((len & 1) == 0) 0.5 * find(nums1,nums2,len/2) + 0.5 * find(nums1,nums2,len/2+1)
  else 1.0 * find(nums1,nums2,(len+1)/2)
}
// TODO

findMedianSortedArrays(
  Array(1,2,3,4,5,6,7,8),
  Array(9,10,11,12,13)
)

findMedianSortedArrays(Array(1,2,2),Array(1,2,3))