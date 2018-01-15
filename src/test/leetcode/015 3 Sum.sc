// sum = 0

def threeSum(nums: Array[Int]): List[List[Int]] = {

  val num = nums.sorted
  val l = nums.length
  var res: List[List[Int]] = Nil

  // for each non-dup element, search among rest (dedup)
  for (i <- 0 until l - 2 if i == 0 || num(i) != num(i - 1)) {
    var lo = i + 1
    var hi = l - 1
    val sum = -num(i)

    while (lo < hi) {
      if (num(lo) + num(hi) == sum) {
        res = List(num(i), num(lo), num(hi)) :: res
        while (lo < hi && num(lo) == num(lo + 1)) lo += 1
        while (lo < hi && num(hi) == num(hi - 1)) hi -= 1
        lo += 1
        hi -= 1
      } else if (num(lo) + num(hi) < sum) {
        while (lo < hi && num(lo) == num(lo + 1)) lo += 1
        lo += 1
      }
      else {
        while (lo < hi && num(hi) == num(hi - 1)) hi -= 1
        hi -= 1
      }
    }
  }

  res
}

threeSum(Array(-1, 0, 1, 2, -1, -4))