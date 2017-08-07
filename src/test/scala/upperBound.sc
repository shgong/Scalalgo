import scala.annotation.tailrec

def lowerBound(arr: Array[Int], key: Int): Int = {
  // binary search, return first element >= key
  @tailrec
  def search(lo: Int, hi: Int): Int = {
    if (hi-lo <= 1) hi
    else {
      val mid: Int = (hi + lo) / 2
      if (arr(mid) >= key) search(lo, mid)
      else search(mid, hi)
    }
  }
  search(-1, arr.length)
}

def upperBound(arr: Array[Int], key: Int): Int = {
  // binary search, return first element >= key
  @tailrec
  def search(lo: Int, hi: Int): Int = {
    if (hi-lo <= 1) lo
    else {
      val mid: Int = (hi + lo) / 2
      if (arr(mid) > key) search(lo, mid)
      else search(mid, hi)
    }
  }
  search(-1, arr.length)
}

List(1,2,3)