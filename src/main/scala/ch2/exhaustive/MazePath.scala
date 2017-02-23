package ch2.exhaustive
import scala.annotation.tailrec
import scala.util.control.Breaks._

// a char maze with start S, goal G, path . and wall #

object MazePath {

  val mazeStr =
    """#S######.#
      |......#..#
      |.#.##.##.#
      |.#........
      |##.##.####
      |....#....#
      |.#######.#
      |....#.....
      |.####.###.
      |....#...G#
    """.stripMargin

  // important replace \r\n
  val maze:Array[Array[Char]] = mazeStr.replace("\r\n", "\n").split("\n").map(_.toCharArray)
  val xm = maze.length
  val ym = maze.head.length
  val start = (0,1)
  val goal = (9,8)

  // imperative solver
  def solve() = {
    val d = Array.fill(xm)(Array.fill(ym)(Integer.MAX_VALUE))
    val que = scala.collection.mutable.Queue(start)
    d(start._1)(start._2) = 0

    breakable {
      while (que.nonEmpty) {
        val p = que.dequeue()
        if (p == goal) break()

        List((p._1 + 1, p._2), (p._1 - 1, p._2), (p._1, p._2 + 1), (p._1, p._2 - 1))
          .filter { case (x, y) => x >= 0 && x < xm && y >= 0 && y < ym && maze(x)(y) != '#' && d(x)(y) == Integer.MAX_VALUE }
          .foreach { pn => que.enqueue(pn); d(pn._1)(pn._2) = d(p._1)(p._2) + 1}
      }
    }

    d(goal._1)(goal._2)
  }

  // tail rec & iterator solver
  def solve2() =  {
    val d = Array.fill(xm)(Array.fill(ym)(Integer.MAX_VALUE))
    val que = Iterator.single(start)
    d(start._1)(start._2) = 0

    @tailrec
    def bfs(i: Iterator[(Int, Int)]): Unit = {
      if (i.hasNext) {
        val p = i.next()
        if (p != goal) {
          val neighbors = List((p._1 + 1, p._2), (p._1 - 1, p._2), (p._1, p._2 + 1), (p._1, p._2 - 1))
            .filter { case (x, y) => x >= 0 && x < xm && y >= 0 && y < ym &&
              maze(x)(y) != '#' && d(x)(y) == Integer.MAX_VALUE }
          neighbors.foreach { pn => d(pn._1)(pn._2) = d(p._1)(p._2) + 1 }
          bfs(i ++ neighbors.iterator)
        }
      }
    }

    bfs(Iterator.single(start))
    // d.foreach { row => println(row.map { case Integer.MAX_VALUE => "##" case x => "%2d".format(x)}.mkString(" "))}
  }

}
