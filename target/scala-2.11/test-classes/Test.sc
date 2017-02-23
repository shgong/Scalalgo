import ch1._
import ch2._
import util.Timer._
import scala.util.Random


import scala.annotation.tailrec

def quicksort[A](xs: Stream[A])(implicit o: Ordering[A]): Stream[A] = {
  import o._
  if (xs.isEmpty) xs else {
    val (smaller, bigger) = xs.tail.partition(_ < xs.head)
    quicksort(smaller) #::: xs.head #:: quicksort(bigger)
  }
}

time (List.fill(100)(Random.nextInt)){x=>
  x.sorted.take(2)
}

time (Stream.fill(100)(Random.nextInt)){x=>
 quicksort(x).take(2)
}

