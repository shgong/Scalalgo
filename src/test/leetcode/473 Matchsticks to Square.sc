// make one square by using up all those matchsticks


def makesquareFullResult(nums: Array[Int]): Boolean = {
  if (nums.isEmpty) return false
  val total = nums.sum
  if (total % 4 != 0) return false
  val side = total / 4

  def search(a: List[Int], b: List[Int], c: List[Int], d: List[Int], res: List[Int]): Boolean = {
    if (res.isEmpty) {
      a.sum == side && b.sum == side && c.sum == side && d.sum == side
    } else {
      val next = res.head
      (a.sum + next <= side && search(next :: a, b, c, d, res.tail)) ||
        (a.sum != b.sum && b.sum + next <= side && search(a, next :: b, c, d, res.tail)) ||
        (b.sum != c.sum && c.sum + next <= side && search(a, b, next :: c, d, res.tail)) ||
        (c.sum != d.sum && d.sum + next <= side && search(a, b, c, next :: d, res.tail))
    }
  }

  search(Nil, Nil, Nil, Nil, nums.toList.reverse)
}

def makesquare(nums: Array[Int]): Boolean = {
  if (nums.isEmpty) return false
  val total = nums.sum
  if (total % 4 != 0) return false
  val side = total / 4

  def search(a: Int, b: Int, c: Int, d: Int, res: List[Int]): Boolean = {
    if (res.isEmpty) a + b + c + d == 0
    else {
      val next = res.head
      val remain = res.tail
      (a >= next && search(a - next, b, c, d, remain)) ||
        (a != b && b >= next && search(a, b - next, c, d, remain)) ||
        (b != c && c >= next && search(a, b, c - next, d, remain)) ||
        (c != d && d >= next && search(a, b, c, d - next, remain))
    }
  }
  search(side, side, side, side, nums.toList.reverse)
}

makesquare(Array(1, 1, 2, 2, 2))