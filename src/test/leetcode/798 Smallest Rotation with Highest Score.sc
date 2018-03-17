/*
 Given an array A, we may rotate it by a non-negative integer K so that the array becomes A[K], A[K+1], A{K+2], ... A[A.length - 1], A[0], A[1], ..., A[K-1].
 Afterward, any entries that are less than or equal to their index are worth 1 point.

For example, if we have [2, 4, 1, 3, 0],
and we rotate by K = 2, it becomes [1, 3, 0, 2, 4].

This is worth 3 points because
1 > 0 [no points],
3 > 1 [no points],
0 <= 2 [one point],
2 <= 3 [one point],
4 <= 4 [one point].

Over all possible rotations,
return the rotation index K that corresponds to the highest score we could receive.
If there are multiple answers, return the smallest such index K.

N(i) = j
j=l-1 rotate >= i+1 to score
j=0   always score
j=1   score except rotate by i
j=2                       by i, i-1
j=3                       by i, i-1, i-2

<=0 always score
>=l not score, ignore

 */

def bestRotation(A: Array[Int]): Int = {
  val l = A.length
  var score = Array.fill(l)(0)
  for (i <- 0 until l) {
    val j = A(i)

    for(r<-0 until l){
      var index = i - r
      if(index<0) index += l
      if(j<=index) score(r) += 1
    }

  }


  var max = score.max
  score.zipWithIndex.find(_._1 == max).get._2
}

bestRotation(Array(2, 3,1,4, 0))
bestRotation(Array(1, 3, 0, 2, 4))