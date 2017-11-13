


def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
  var max = 0
  var current = 0
  nums.foreach {
    case 1 => current += 1
    case 0 =>
      max = current max max
      current = 0
  }
  current max max
}

findMaxConsecutiveOnes(Array(1,0,0,0,0,1))