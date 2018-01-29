
def reversePairs(nums: Array[Int]): Int = {
  import java.util.Arrays

  def mergeSort(nums: Array[Int], s: Int, e: Int): Int = {
    if (s >= e) return 0
    val mid = s + (e - s) / 2

    var cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid + 1, e)
    var j = mid + 1
    for (i <- s to mid) {
      while (j <= e && nums(i) / 2.0 > nums(j)) j += 1
      cnt += j - (mid + 1)  // find each i larger than 2x how many j
    }

    Arrays.sort(nums, s, e + 1)
    cnt
  }

  mergeSort(nums, 0, nums.length - 1)
}

reversePairs(Array(1, 2, 3, 4, 51, 56, 6, 1))