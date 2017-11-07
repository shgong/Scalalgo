package ch4.divide

// find inverse pair in array

// merge sort

object InversePair {

  def solve(a:Array[Int]): Int = {
    val n = a.length
    if(n<=1) return 0

    var count = 0

    val b = a.take(n/2)
    val c = a.drop(n/2)

    count += solve(b)
    count += solve(c)

    // b and c are already in order

    // merge sort, find inverse

    var bi = 0
    var ci = 0
    for(ai <- 0 until n){
      if(bi<b.length && (ci == c.length || b(bi)<c(ci))) {
        a(ai)=b(bi)
        bi += 1
      } else {
        count += n/2 - bi
        a(ai)=c(ci)
        ci += 1
      }
    }

    count
  }


  def main(args:Array[String]) = {
    val res = solve(Array(1,3,5,4,2))
    println(res)
  }

}
