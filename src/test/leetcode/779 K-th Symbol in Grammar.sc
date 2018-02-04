// 779. K-th Symbol in Grammar
// replace each occurrence of 0 with 01,
// and each occurrence of 1 with 10.
/*

row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001

0 -> 0 0 0
5 -> 0 1 1

row N: 2^N-1 char

id pos result
0  0   0
0  1   1
1  0   1
1  1   0
 */

// Given row N and index K, return the K-th indexed symbol in row N
// k is one indexed
def kthGrammar(N: Int, K: Int): Int = {

  var id = 1
  for(i<-0 until N-2)  id <<= 1

  var start = 0
  for(i<-0 until N-1) {
    val pos = if((id & (K-1)) > 0) 1 else 0
    id >>= 1
    start ^= pos
  }
  start
}

kthGrammar(1, 0)
kthGrammar(2, 0)
kthGrammar(2, 1)
kthGrammar(3, 0)
kthGrammar(3, 1)
kthGrammar(3, 2)
kthGrammar(3, 3)


kthGrammar(4, 0)
kthGrammar(4, 1)
kthGrammar(4, 2)
kthGrammar(4, 3)
kthGrammar(4, 4)
kthGrammar(4, 5)
kthGrammar(4, 6)
kthGrammar(4, 7)