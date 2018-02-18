


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

  val a = A.sorted
  val l = a.length

  var lo = 0D
  var hi = 1D

  // binary search a number to see how many prime smaller
  import collection.Searching._

  for(rep <- 0 until 50){
    val x = lo + (hi - lo) / 2
    var num = 0
    for(i<-0 until l){
        a.search( (x * a(i)).toInt) match {
          case Found(x) => num += x + 1
          case InsertionPoint(x) => num += x
        }
    }

    if(num >= K) hi = x else lo = x
  }

  println(hi)

  // find closest number to hi (when=K assign to hi)
  var eps = 1e-14
  while(true){
    for {
      i <- 0 until l
      ln = hi * a(i)
      j <- 0 until i
      if Math.abs(ln - a(j)) < eps
    } return Array(a(j), a(i))

    eps *= 10
  }

  Array()
}

/*
		        for(int i = 0;i < n;i++){
		        	double ln = high * a[i];
		        	for(int j = 0;j < i;j++){
		        		if(Math.abs(ln-a[j]) < eps){
		        			return new int[]{a[j], a[i]};
		        		}
		        	}
		        }

 */


kthSmallestPrimeFraction(Array(1, 2, 3, 5),3)
kthSmallestPrimeFraction(Array(1, 7),1)