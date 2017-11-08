package ch4.str

object Sequence {
  // Array A, first element is max
  // split into three sequence, and inverse them
  // what is the smallest inversed sequence in (dict order)

  // example 10,1,2,3,4
  // into 10,1 - 2 - 3,4
  // after inverse 1,10,2,4,3

  def solve(A:Array[Int]): Array[Int] = {

    val n = A.length
    val rev = A.reverse
    val sa = constructSuffixArray(rev)

    // split 1: first i to leave enough space
    val p1 = n - sa.find(x => x >= 1 && x <= n - 2 ).get
    val rest = A.drop(p1)

    // split 2: reverse both part
    //  is like double the array and reverse
    val double = (rest ++ rest).reverse

    val sa2 = constructSuffixArray(double)
    val p2 = rest.length - sa2.find(x=> x>=1 && x<= rest.length -1).get

    // output
    val res = A.take(p1).reverse ++ rest.take(p2).reverse ++ rest.drop(p2).reverse
    println("--- result --- \n" + res.toList)
    res
  }


  // suffix array
  // dictionary ordered of substring form middle to end

  // naive, sort n string,  n^2 logn
  // use suffix property, n (logn)^2

  def constructSuffixArray(s:Array[Int]): Array[Int] = {
    val n = s.length


    var k = 1
    var sa = s.indices.toArray
    var rank = s

    // compare rank(i) rank(i+k) and rank(j) rank(j+k)
    def compare_sa(i:Int, j:Int) = {
      if  (rank(i)!=rank(j)) rank(i) < rank(j)  // compare first part
      else (if (i+k<n) rank(i+k) else -1) < (if (j+k<n) rank(j+k) else -1) // if second part empty, smaller
    }

    // sort length 2k using length k result
    while(k <= n) {
      sa = sa.sortWith(compare_sa)

      // calculate rank, don't increase if same
      val tmp = Array.fill(n)(0)
      for (i<-1 until n) tmp(sa(i)) = tmp(sa(i-1)) + (if (compare_sa(sa(i-1), sa(i))) 1 else 0)
      rank = tmp
      k *= 2
    }

    // print
    println("--- suffix array ---")
    sa.map(s.drop(_)).foreach(x=>println(x.toList))

    sa
  }


  def main(args:Array[String]) = {
    val res = solve(Array(10,1,2,3,4))
  }

}
