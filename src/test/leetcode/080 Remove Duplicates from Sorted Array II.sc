// dups are allowed at most twice

def removeDuplicates(nums: Array[Int]): Int = {

  var last = Integer.MIN_VALUE
  var repeat = false
  var j = 0

  for (i <- nums.indices) {
    if (nums(i) != last) {
      last = nums(i)
      repeat = false
      nums(j) = nums(i)
      j += 1
    } else if (!repeat) {
      nums(j) = nums(i)
      repeat = true
      j += 1
    }
  }

  j
}

var x = Array(1, 1, 1, 2, 2, 3)
removeDuplicates(x)
x.toList

x = Array(1, 1, 1)
removeDuplicates(x)
x.toList

def removeDuplicates2(nums: Array[Int]) = {
  var i = 0
  for (n <- nums if i < 2 || n > nums(i - 2)) {
    nums(i) = n
    i += 1
  }
  i
}