/*

Given an m * n matrix M
all 0's, several update operations.

2D array, with two positive integers a and b
M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers
 */


// Brute Force
def maxCountBF(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
  val mat = Array.fill(m)(Array.fill(n)(0))
  for(Array(a,b)<-ops){
    for(i<-0 until a; j<-0 until b){
      mat(i)(j)+=1
    }
  }
  val max = mat(0)(0)
  mat.flatten.count(_==max)
}

def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
  if(ops.isEmpty) return m*n

  var minx = Integer.MAX_VALUE
  var miny = Integer.MAX_VALUE

  for(i<-ops){
    if(i(0)<minx) minx = i(0)
    if(i(1)<miny) miny = i(1)
  }
  minx * miny
}

maxCount(3,3,Array(Array(1,2)))