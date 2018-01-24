def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {

  def merge(a:Array[Int], b:Array[Int]): Array[Int] = {
    val la = a.length
    val lb = b.length
    val c = Array.fill(la+lb)(0)
    var i = 0
    var j = 0
    while(i+j<la+lb){
      if(i>=la) { c(i+j) = b(j); j+=1  }
      else if(j>=lb) { c(i+j) = a(i); i+=1}
      else if(a(i)<=b(j)){ c(i+j) = a(i); i+=1}
      else { c(i+j) = b(j); j+=1}
    }
    c
  }

  val r:Array[Int] = matrix.reduce(merge)
  r(k-1)
}

import helper.Util._
val matrix = arrayArray[Int]("[[1,5,9],[10,11,13],[12,13,15]]")
kthSmallest(matrix, 8)