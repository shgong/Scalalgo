/*
k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

absolute different: k>0
 */

def findPairs(nums: Array[Int], k: Int): Int = {
  if(k<0) 0
  else if(k==0) nums.groupBy(identity).values.count(_.length>=2)
  else {
    val n = nums.groupBy(identity).keys.toList
    n.count(x=> n.contains(x+k))
  }
}

findPairs(Array(3,1,4,1,5),2)
findPairs(Array(1,2,3,4,5),1)
findPairs(Array(1,3,1,5,4),0)