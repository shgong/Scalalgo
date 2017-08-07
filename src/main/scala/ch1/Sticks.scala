package ch1

// the largest perimeter of triangle form by numbers, output 0 if none
object Sticks {

  // O(n^3)
  def naive(a:Array[Int]) = {
    val n = a.length
    var ans = 0
    for (
      i <- 0 until n;
      j <- i+1 until n;
      k <- j+1 until n;
      l = Array(a(i),a(j),a(k));
      sum = l.sum if sum > 2 * l.max
    ) ans = sum

    ans
  }

  // O(nlogn)
  def sort(n:Int, a:Array[Int]) = {
    val eval = a.sorted(Ordering[Int].reverse).toList.view
      .sliding(3)
      .filter(x=>x(0)<x(1)+x(2))
      .map(_.sum)

    if(eval.hasNext) eval.next() else 0
  }
}
