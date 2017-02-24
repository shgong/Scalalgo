


  val w = Array(2,1,3,2)
  val v = Array(3,2,4,2)
  val W  = 5

  val max_v = v.max
  val l = w.length
  val dp = Array.fill(l+1)(Array.fill(l*max_v+1)(Double.PositiveInfinity))
  dp(0)(0) = 0

  // the minimum wei
  for (i <- 0 until l; j <- 0 to l*max_v) {
    if (j < v(i)) dp(i+1)(j) = dp(i)(j)
    else dp(i+1)(j) = math.min(dp(i)(j), dp(i)(j - v(i)) + w(i))
  }

  dp(l).view.zipWithIndex
    .filter(_._1<=W)
    .filter(!_._1.isInfinity)
    .last._2