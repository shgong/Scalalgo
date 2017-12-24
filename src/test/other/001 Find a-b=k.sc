import scala.util.Random

val a = (1 to 100).filter(_=>Random.nextBoolean).toArray

def findK(a:Array[Int], k:Int) = {
  (a intersect a.map(_+k)) map {x=>(x-k,x)}
}

findK(a, 4)
findK(a, 5)
findK(a, 8)