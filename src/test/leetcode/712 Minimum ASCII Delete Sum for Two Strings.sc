// find the lowest ASCII sum of deleted characters to make two strings equal.

// substring cmp problem => dp
// record maximum cost of kept
def minimumDeleteSum(s1: String, s2: String): Int = {
  val l1 = s1.length
  val l2 = s2.length
  val dp = Array.fill(l1+1)(Array.fill(l2+1)(0))

  for(i<-0 until l1; j<-0 until l2)
    if(s1(i)==s2(j)) dp(i+1)(j+1) = dp(i)(j) + s1(i).toInt * 2
    else dp(i+1)(j+1) = dp(i)(j+1) max dp(i+1)(j)

  s1.sum + s2.sum - dp(l1)(l2)
}


minimumDeleteSum("delete", "leet")
