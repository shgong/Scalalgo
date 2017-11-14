class NumArray(_nums: Array[Int]) {

  val nums = _nums
  val n = nums.length
  val BIT = new Array[Int](n + 1)
  (0 until n).foreach(i=>init(i, nums(i)))

  // BIT update 1 2 4 8 16...
  // next update always be i + i & -i
  // -i is negate + 1
  def init(pos: Int, v: Int): Unit = {
    var i = pos + 1
    while (i <= n) {
      BIT(i) += v
      i += (i & -i)
    }
  }

  def update(i: Int, `val`: Int) = {
    val diff = `val` - nums(i)
    nums(i) = `val`
    init(i, diff)
  }

  def sumRange(i: Int, j: Int): Int = {
    def sum(pos:Int) = {
      var i = pos + 1
      var sum = 0
      while(i>0){
        sum += BIT(i)
        i -= i & -i
      }
      sum
    }

    sum(j) - sum(i-1)
  }

}

// Range Sum
// Use Binary Index Tree


-2 << 1
-2 >> 1
-1 >> 1

1 & -1
2 & -2
3 & -3
4 & -4