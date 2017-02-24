
val a = Array(1,41,56,3,32,352,6,2,1,241,124,123,1,515151)

  val dp = Array.fill(a.length)(1)
  for (i <- a.indices; j <- 0 until i if a(j)<a(i))
      dp(i) = math.max(dp(i), dp(j)+1)
  dp.max