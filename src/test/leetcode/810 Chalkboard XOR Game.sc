// Chalkboard XOR Game
/*
 If erasing a number causes the bitwise XOR of all the elements of the chalkboard to become 0,
 then that player loses.
 (Also, we'll say the bitwise XOR of one element is that element itself,
 and the bitwise XOR of no elements is 0.)

Return True if and only if Alice wins the game, assuming both players play optimally.
 */


def xorGame(nums: Array[Int]): Boolean = {
  // just depend on who remove last element
  // when there is even element, A won't face a scenario
  // that A can not remove any element
  nums.foldLeft(0)(_ ^ _) == 0 || nums.length % 2 == 0
}



/*
Min In Max

Consider alice auto win when xor = 0 ???
TLE
 */
def xorGameMIM(nums: Array[Int]): Boolean = {

  val xor = nums.foldLeft(0)(_ ^ _)
  val num = nums.sorted.toList

  def aliceWin(nums: List[Int], xor: Int): Boolean = {
    var i = 0
    if (xor == 0) return true

    while (i < nums.length) {
      val nextxor = nums(i) ^ xor
      if (bobLose(nums.take(i) ++ nums.drop(i + 1), nextxor)) return true
      while (i < nums.length - 1 && nums(i) == nums(i + 1)) i += 1
      i += 1
    }

    false
  }

  def bobLose(nums: List[Int], xor: Int): Boolean = {
    var i = 0
    if (xor == 0) return false

    while (i < nums.length) {
      val nextxor = nums(i) ^ xor
      if (!aliceWin(nums.take(i) ++ nums.drop(i + 1), nextxor)) return false
      while (i < nums.length - 1 && nums(i) == nums(i + 1)) i += 1
      i += 1
    }
    true
  }

  aliceWin(num, xor)

}

xorGame(Array(1, 1, 2))
xorGame(Array(0, 1))
xorGame(Array(0, 0, 0, 1))
xorGame(Array(1, 2, 3))