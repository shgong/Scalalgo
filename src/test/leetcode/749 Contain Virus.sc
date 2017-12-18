def containVirus(grid: Array[Array[Int]]): Int = {
  // find area with most target
  val h = grid.length
  if (h < 1) return 0
  val w = grid(0).length
  if (w < 1) return 0

  grid.foreach(x => println(x.toList))
  var current = grid.clone()
  var walls = 0
  var currentWall = 0

  while (true) {
    var s = current.clone()

    def sink(x: Int, y: Int): Unit = {
      if (x >= 0 && x < h && y >= 0 && y < w) {
        if (s(x)(y) == 0) {
          s(x)(y) = -1
          currentWall += 1
        } else if (s(x)(y) == -1) {
          currentWall += 1
        }
        else if (s(x)(y) == 1) {
          s(x)(y) = -2 // virus
          sink(x - 1, y)
          sink(x + 1, y)
          sink(x, y - 1)
          sink(x, y + 1)
        }
      }
    }

    def block(x: Int, y: Int): Unit = {
      if (x >= 0 && x < h && y >= 0 && y < w) {
        if (s(x)(y) == -2) {
          s(x)(y) = -3 // blocked
          block(x - 1, y)
          block(x + 1, y)
          block(x, y - 1)
          block(x, y + 1)
        }
      }
    }

    def infected(x: Int, y: Int): Boolean = {
      if (x >= 0 && x < h && y >= 0 && y < w) {
        if (s(x)(y) == -2) return true
      }
      return false
    }

    def cleanCount(): Int = {
      var res = 0
      for (i <- 0 until h; j <- 0 until w) {
        if (s(i)(j) == -1) {
          s(i)(j) = 0
          res += 1
        }
      }
      res
    }


    val areas = collection.mutable.ArrayBuffer[(Int, Int, Int, Int)]()

    for (i <- 0 until h; j <- 0 until w) {
      if (s(i)(j) == 1) {
        println(s"$i $j")
        sink(i, j)
        // count & reset -1, -2
        val effected = cleanCount()
        areas.append((i, j, currentWall, effected))
        currentWall = 0
      }
    }
    println(areas)

    if (areas.isEmpty) return walls
    if (areas.map(_._4).sum ==0 ) return walls

    val toWall = areas.maxBy(_._3)
    walls += toWall._3

    // set current to blocked
    block(toWall._1, toWall._2)


    // let other infect
    for (i <- 0 until h; j <- 0 until w if s(i)(j) == 0) {
      if (infected(i - 1, j) || infected(i + 1, j) || infected(i, j - 1) || infected(i, j + 1))
        s(i)(j) = 1
    }
    for (i <- 0 until h; j <- 0 until w if s(i)(j) == -2) {
      s(i)(j) = 1
    }

    s.foreach(x => println(x.toList))
    current = s

  }

  1
}



val g3 = Array(Array(0,1,0,1,1,1,1,1,1,0),Array(0,0,0,1,0,0,0,0,0,0),Array(0,0,1,1,1,0,0,0,1,0),Array(0,0,0,1,1,0,0,1,1,0),Array(0,1,0,0,1,0,1,1,0,1),Array(0,0,0,1,0,1,0,1,1,1),Array(0,1,0,0,1,0,0,1,1,0),Array(0,1,0,1,0,0,0,1,1,0),Array(0,1,1,0,0,1,1,0,0,1),Array(1,0,1,1,0,1,0,1,0,1))
containVirus(g3)