// BIT
class NumArray(_nums: Array[Int]) {

  val nums = _nums
  val n = nums.length
  val BIT = new Array[Int](n + 1)
  (0 until n).foreach(i=>init(i, nums(i)))

  def init(pos: Int, v: Int): Unit = {
    var i = pos + 1
    while (i <= n) {
      BIT(i) += v
      i += (i & -i)
    }
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
val c = new NumArray(Array(1,3,4,5,5,6,1,2,5,0,1,2,123,13,5))
c.sumRange(1,4)