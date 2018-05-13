/*
Two images A and B are given,
represented as binary, square matrices of the same size.
(A binary matrix has only 0s and 1s as values.)

We translate one image however we choose
(sliding it left, right, up, or down any number of units),
and place it on top of the other image.

After, the overlap of this translation
the number of positions that have a 1 in both images.

What is the largest possible overlap?

1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1

 */

def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
  val l = A.length

  var lap = 0
  for(x<- 1-l to l-1; y<- 1-l to l-1){
    var count = 0
    // x=10 y=0
    // 10 until
    for(i<-(0 max x) until (l min (l+x));
        j<-(0 max y) until (l min (l+y))
      if A(i)(j) == 1 && B(i-x)(j-y)==1) count += 1

    lap = lap max count

    println(x,y,lap)
  }

  lap
}

largestOverlap(
  Array(Array(0,1),Array(1,1)),
  Array(Array(1,1),Array(1,0))
)

largestOverlap(
  Array(
    Array(1,1,0),
    Array(0,1,0),
    Array(0,1,0)
  ),
  Array(
    Array(0,0,0),
    Array(0,1,1),
    Array(0,0,1)
  )
)