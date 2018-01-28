// 773. Sliding Puzzle

// array's can be duplicate in hashset
// use immutable data structure
def slidingPuzzle(board: Array[Array[Int]]): Int = {
  val history = collection.mutable.HashSet[List[List[Int]]]()
  val init = board.toList.map(_.toList)

  var state = Set(init)
  history += init
  var step = 0

  def checkFinish(b: List[List[Int]]): Boolean = {
    b(0)(0) == 1 && b(0)(1) == 2 && b(0)(2) == 3 &&
      b(1)(0) == 4 && b(1)(1) == 5
  }

  if (checkFinish(init)) return 0

  while (step < 20) {
    // println(step, state.size, history.size)
    step += 1
    state = state.flatMap { current =>
      val List(List(a, b, c), List(d, e, f)) = current
      val avail =
        if (a == 0) Set(List(List(b, a, c), List(d, e, f)), List(List(d, b, c), List(a, e, f)))
        else if (b == 0) Set(List(List(b, a, c), List(d, e, f)), List(List(a, c, b), List(d, e, f)), List(List(a, e, c), List(d, b, f)))
        else if (c == 0) Set(List(List(a, c, b), List(d, e, f)), List(List(a, b, f), List(d, e, c)))
        else if (d == 0) Set(List(List(d, b, c), List(a, e, f)), List(List(a, b, c), List(e, d, f)))
        else if (e == 0) Set(List(List(a, e, c), List(d, b, f)), List(List(a, b, c), List(e, d, f)), List(List(a, b, c), List(d, f, e)))
        else Set(List(List(a, b, f), List(d, e, c)), List(List(a, b, c), List(d, f, e)))

      val res = avail.filter(!history.contains(_))

      for (i <- res) {
        history += i
        if (checkFinish(i)) return step
      }

      res
    }

  }

  return -1

}

slidingPuzzle(Array(Array(1, 2, 3), Array(4, 0, 5)))
slidingPuzzle(Array(Array(4, 1, 2), Array(5, 0, 3)))
slidingPuzzle(Array(Array(3, 2, 4), Array(1, 5, 0)))

slidingPuzzle(Array(Array(1, 2, 3), Array(5, 4, 0)))