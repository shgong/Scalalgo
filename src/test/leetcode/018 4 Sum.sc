def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
  var res = List[List[Int]]()
  val l = nums.length
  var n = nums.sorted
  val limit = target / 4

  for {
    i <- 0 until l - 3 if n(i) <= limit && (i == 0 || n(i) != n(i - 1))
    j <- l-1 until i+2 by -1 if n(j)>= limit && (j==l-1 || n(j) != n(j+1))
  } {
    var lo = i + 1
    var hi = j - 1
    var two = n(i) + n(j)
    var limit2 = (target - two)/2

    while(lo<hi && n(lo)<=limit2 && n(hi)>= limit2){
      val sum = two + n(lo) + n(hi)
      if(sum == target){
        res ::= List(n(i),n(lo),n(hi),n(j))
        while(lo<hi && n(hi)==n(hi-1)) hi -= 1
        while(lo<hi && n(lo)==n(lo+1)) lo += 1
      }
      if(sum<=target) lo += 1
      if(sum>=target) hi -= 1
    }
  }
  res
}

fourSum(Array(1, 0, -1, 0, -2, 2),0)