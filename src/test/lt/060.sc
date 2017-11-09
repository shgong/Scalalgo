// Permutation Sequence

def getPermutation(n: Int, k: Int): String = {
  val l = collection.mutable.ArrayBuffer("123456789":_*)
  var m = k - 1
  val factor = (1 until n).scanLeft(1)(_ * _).drop(1).reverse

  factor.map{i=>
    val c = m / i
    m = m % i
    l.remove(c)
  }.mkString("") + l(0)
}

getPermutation(2,1)