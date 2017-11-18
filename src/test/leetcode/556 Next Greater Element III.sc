
// Next Greater Element with 32 bit digit
// 031 Next Permutation
// 32 bit integer limit

def nextGreaterElement(n: Int): Int = {
  val nums = n.toString.toCharArray.map(_ - '0')

  var i = nums.length - 2
  while (i >= 0 && nums(i) >= nums(i + 1)) i -= 1
  // Find 1st id i that breaks descending order

  if (i < 0) return -1

  var j = nums.length - 1
  while (nums(j) <= nums(i)) j -= 1 // Find rightmost first larger id j
  swap(nums, i, j)

  reverse(nums, i + 1, nums.length - 1)
  scala.util.Try(nums.mkString.toInt).getOrElse(-1)
}

def swap(k: Array[Int], i: Int, j: Int) = {
  val tmp = k(i)
  k(i) = k(j)
  k(j) = tmp
}

def reverse(k: Array[Int], i: Int, j: Int) {
  var a = i
  var b = j
  while (a < b) {
    swap(k, a, b)
    a += 1
    b -= 1
  }
}


nextGreaterElement(113)

