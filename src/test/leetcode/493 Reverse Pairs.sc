// Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j]


import collection.Searching.search

def reversePairs(nums: Array[Int]): Int = {

  val l = nums.length
  val bit = Array.fill(l + 1)(0)
  var res = 0

  // use sorted array to mark relative value rank
  val sort = nums.sorted

  // inverse bit, track larger number
  def insert(i: Int) = {
    var x = i + 1
    while (x > 0) {
      bit(x) += 1
      x -= (x & -x)
    }
  }

  def find(i: Int): Int = {
    var sum = 0
    var x = i + 1
    while (x <= l) {
      sum += bit(x)
      x += (x & -x)
    }
    sum
  }

  for (x <- nums) {
    if (x > Integer.MAX_VALUE / 2) res += find(l)
    else if (x > Integer.MIN_VALUE / 2) res += find(sort.search(2 * x + 1).insertionPoint)
    else res += find(0)

    println(s"$x $res")

    val full = sort.search(x).insertionPoint
    insert(full)
  }
  res
}

reversePairs(Array(10, 1, 2, 3, 4, 5, 6, 1))
reversePairs(Array(1, 3, 2, 3, 1))
reversePairs(Array(2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647))
reversePairs(Array(2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647))
reversePairs(Array(-5,-5))