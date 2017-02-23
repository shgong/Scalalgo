package ch2.exhaustive

// check how many water lake in a W* table
object LakeCount {

  val lake =
    """W........WW.
      |.WWW.....WWW
      |....WW...WW.
      |.........WW.
      |.........W..
      |..W......W..
      |.W.W.....WW.
      |W.W.W.....W.
      |.W.W......W.
      |..W.......W.""".stripMargin

  // important replace \r\n
  val table:Array[Array[Char]] = lake.replace("\r\n", "\n").split("\n").map(_.toCharArray)

  // O(8*N*M)
  def solve(table: Array[Array[Char]]): Int = {
    val max_x = table.length
    val max_y = table.head.length
    var r = 0

    // starting from any W, replace 8-direction neighbour with .
    def dfs(x:Int,y:Int): Unit = {
      for (
        i <- x-1 to x+1;
        j <- y-1 to y+1
      ) if (i>=0 && j>=0 && i<max_x && j<max_y && table(i)(j) == 'W') {
        table(i)(j) = '.'
        dfs(i,j)
      }
    }

    // check how many replace loop
    for (
      i <- 0 until max_x - 1;
      j <- 0 until max_y
     if table(i)(j) == 'W'
    ) {
        table(i)(j) = '.'
        dfs(i,j)
        r += 1
      }


    r
  }

  def main(args:Array[String]): Unit ={
    println(solve(table))
  }

}
