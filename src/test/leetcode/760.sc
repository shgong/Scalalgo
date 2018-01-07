// Find Anagram Mappings

def anagramMappings(A: Array[Int], B: Array[Int]): Array[Int] = {
  val k = collection.mutable.Set(B.zipWithIndex:_*)
  A.map{ b =>
    val r = k.find(_._1 == b).get
    k.remove(r)
    r._2
  }

}

anagramMappings(
  Array(12, 28, 46, 32, 50),
  Array(50, 12, 32, 46, 28)
)