// sum = 0

def threeSumClosest(nums: Array[Int], target: Int): Int = {

  val num = nums.sorted
  val l = nums.length

  var res: Int = nums.take(3).sum

  // for each non-dup element, search among rest (dedup)
  for (i <- 0 until l - 2 if i == 0 || num(i) != num(i - 1)) {
    var lo = i + 1
    var hi = l - 1
    val sum = target - num(i)

    while (lo < hi) {
      if (num(lo) + num(hi) == sum) return target
      else if (num(lo) + num(hi) < sum) {
        val t = num(lo) + num(hi) + num(i)
        if(Math.abs(t-target)<Math.abs(res-target)) res = t
        while (lo < hi && num(lo) == num(lo + 1)) lo += 1
        lo += 1
      }
      else {
        val t = num(lo) + num(hi) + num(i)
        if(Math.abs(t-target)<Math.abs(res-target)) res = t
        while (lo < hi && num(hi) == num(hi - 1)) hi -= 1
        hi -= 1
      }
    }
  }

  res
}

threeSumClosest(Array(-1, 2, 1, -4), 1)