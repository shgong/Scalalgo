/*
 In each move, you can swap any 2 rows with each other,
 or any 2 columns with each other.

the minimum number of moves to transform the board into a "chessboard"
a board where no 0s and no 1s are 4-directionally adjacent?

If the task is impossible, return -1.
 */

def movesToChessboard(board: Array[Array[Int]]): Int = {

  val l = board.length
  val b = board.toList.map(_.toList)

  var swap = 0


  val s = board.map(_.sum).sum
  val max = l * l
  var top = 0
  if(l%2 == 0){
    if(s!= max/2) return -1
    top = board(0)(0)
  } else {
    if(s > max - s) top = 1
    else top = 0
  }

  //println(top)


  val rows = b.groupBy(identity).mapValues(_.length).toList

  if(rows.length != 2) return -1
  if(l % 2 == 0 && rows(0)._2 != l/2) return -1
  if(l % 2 != 0 && !List(l/2, l/2+1).contains(rows(0)._2)) return -1

  for(i<-0 until l){
    if(rows(0)._1.apply(i) + rows(1)._1.apply(i) != 1) return -1
  }

  println(rows)
  if(rows(0)._2 > rows(1)._2) {
    // tune rows(0)
    val row = rows(0)._1

    if(l % 2 == 0 && row.sum != l/2) return -1
    if(l % 2 != 0 && row.count(_==top)!= l/2 + 1) return -1


    for(j<- 0 until l by 2){
      if(row(j) != top) swap += 1
      if(b(j) != row) swap += 1
    }

  } else if(rows(0)._2 < rows(1)._2) {
    // tune rows(1)
    val row = rows(1)._1
    if(l % 2 == 0 && row.sum != l/2) return -1
    if(l % 2 != 0 && row.count(_==top)!= l/2 + 1) return -1

    for(j<- 0 until l by 2){
      if(row(j) != top) swap += 1
      if(b(j) != row) swap += 1
    }

  } else  {
    // tune rows(1)
    var row = rows(0)._1

    var swap1 = 0
    if(l % 2 == 0 && row.sum != l/2) return -1

    for(j<- 0 until l by 2){
      if(row(j) != top) swap1 += 1
      if(b(j) != row) swap1 += 1
    }


    row = rows(1)._1
    var swap2 = 0
    if(l % 2 == 0 && row.sum != l/2) return -1

    for(j<- 0 until l by 2){
      if(row(j) != top) swap2 += 1
      if(b(j) != row) swap2 += 1
    }

    swap = swap1 min swap2
  }


  swap

}

movesToChessboard(Array(
  Array(1,0,0,1),
  Array(1,0,0,1),
  Array(0,1,1,0),
  Array(0,1,1,0)
))
movesToChessboard(Array(
  Array(1,1,1,0),
  Array(1,1,1,0),
  Array(0,0,0,1),
  Array(0,0,0,1)
))
movesToChessboard(Array(
  Array(0,1),
  Array(1,0)
))
movesToChessboard(Array(
  Array(1,0),
  Array(1,0)
))

movesToChessboard(Array(
  Array(1,1,0),
  Array(0,0,1),
  Array(0,0,1)
))