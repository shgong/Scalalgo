


/*
K-th Smallest Prime Fraction

A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.

What is the K-th smallest fraction considered?
 */


// brute
def kthSmallestPrimeFractionBrute(A: Array[Int], K: Int): Array[Int] = {

  val l = A.length
  val list = for(i<-0 until l-1; j<-i+1 until l) yield (1.0*A(i)/A(j),A(i),A(j))

  val res = list.sortBy(_._1).apply(K-1)
  Array(res._2, res._3)
}

def kthSmallestPrimeFraction(A: Array[Int], K: Int): Array[Int] = {

  val l = A.length
  val list = for(i<-0 until l-1; j<-i+1 until l) yield (1.0*A(i)/A(j),A(i),A(j))

  val res = list.sortBy(_._1).apply(K-1)
  Array(res._2, res._3)
}


kthSmallestPrimeFraction(Array(1, 2, 3, 5),3)
kthSmallestPrimeFraction(Array(1, 7),1)