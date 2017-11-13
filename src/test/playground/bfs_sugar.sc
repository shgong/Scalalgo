import scala.util.control.Breaks._


/*
// literal, allow map
val t = ((x: Int, y: Int) => maze(x)(y)).tupled
List((0, 1), (9, 8)).map(t)

// allow method
implicit class MazeWrapper[T](a: Array[Array[T]]) {
  def apply(t:(Int,Int)): T = a(t._1)(t._2)
  def set(t:(Int,Int), v: T): Unit = a(t._1).update(t._2, v)
}
*/

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
    |....#...G#""".stripMargin

// important replace \r\n
val maze: Array[Array[Char]] = mazeStr.replace("\r", "").split("\n").map(_.toCharArray)

val xm = maze.length
val ym = maze.head.length
val goal = (9, 8)

val d = Array.fill(xm)(Array.fill(ym)(Integer.MAX_VALUE))
d(0)(1) = 0

def dfs(i: Iterator[(Int, Int)]): Unit = {
  if (i.hasNext) {
    val p = i.next()
    if (p != goal) {
      val neighbors = List((p._1 + 1, p._2), (p._1 - 1, p._2), (p._1, p._2 + 1), (p._1, p._2 - 1))
        .filter { case (x, y) => x >= 0 && x < xm && y >= 0 && y < ym &&
            maze(x)(y) != '#' && d(x)(y) == Integer.MAX_VALUE }
      neighbors.foreach { pn => d(pn._1)(pn._2) = d(p._1)(p._2) + 1 }
      dfs(i ++ neighbors.iterator)
    }
  }
}
dfs(Iterator.single((0, 1)))
d.foreach { row => println(row.map { case Integer.MAX_VALUE => "##" case x => "%2d".format(x)}.mkString(" "))}