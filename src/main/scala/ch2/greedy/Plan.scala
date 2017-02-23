package ch2.greedy

// there are n jobs with start and end, do as much job as possible

object Plan {

  val s = List(1, 2, 4, 6, 8)
  val t = List(3, 5, 7, 9, 10)

  // greedy: always choose a job ends early
  def solve(s: Array[Int], t: Array[Int]) = {
    t.zip(s).sorted.foldLeft((0, 0)) { case ((current, job), (end, start)) =>
      if (current < start) (end, job + 1)
      else (current, job)
    }
  }

}
