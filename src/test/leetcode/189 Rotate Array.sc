import java.util

/*
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */

def rotate(nums: Array[Int], k: Int): Unit = {
  val l = nums.length
  val r = k % l

  // nums.takeRight(r) ++ nums.dropRight(r)
  val ref = nums.clone()
  for(i<-0 until l) nums(i) = ref((i+l-r) % l)
}

rotate(Array(1,2), 1)