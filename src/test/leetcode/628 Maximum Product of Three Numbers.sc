// max proudct of three numbers

def maximumProduct(nums: Array[Int]): Int = {
  val pos = nums.filter(_ >= 0).sorted
  val neg = nums.filter(_ < 0).sorted
  val lp = pos.length
  val ln = neg.length

  if (lp >= 3 && ln >= 2)
    pos.takeRight(3).product max (pos.takeRight(1) ++ neg.take(2)).product
  else if (lp >= 3) pos.takeRight(3).product
  else if (lp >= 1 && ln >= 2) (pos.takeRight(1) ++ neg.take(2)).product
  else if (lp >= 2) (pos.take(2) ++ neg.takeRight(1)).product
  else neg.takeRight(3).product
}

maximumProduct(Array(-1, 2, 3))
maximumProduct(Array(-4, -1, 2, 3))
maximumProduct(Array(-4, -3, -1, 5, 6, 7))
maximumProduct(Array(-1,-2,-3))