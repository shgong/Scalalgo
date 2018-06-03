/*
Longest Mountain in Array

Let's call any (contiguous) subarray B (of A)
a mountain


B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.
 */
def longestMountain(A: Array[Int]): Int = {
  val l = A.length

  val inc = Array.fill(l)(0)
  val dec = Array.fill(l)(0)

  var count = 0
  for(i<- 1 until l){
    if(A(i)>A(i-1)) count += 1 else count = 0
    inc(i) = count
  }

  count = 0
  for(i<- l-2 to 0 by -1){
    if(A(i)>A(i+1)) count += 1 else count = 0
    dec(i) = count
  }

  if(inc.isEmpty) return 0

  inc.zip(dec).map { case (a, b) =>
    if (a >= 1 && b >= 1) a + b + 1
    else 0
  }.max
}

longestMountain(Array(2,1,4,7,3,2,5))
longestMountain(Array(8,5,1,2,3,4,5,5,4,3,2,1))
longestMountain(Array(8,5,1,2,3,4,5,6,5,4,3,2,1))
longestMountain(Array(2,2,2))