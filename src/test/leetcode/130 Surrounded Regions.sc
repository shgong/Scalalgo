// A region is captured by flipping all 'O's into 'X's in that surrounded region.


val board = Array("XXXX","XOOX","XXOX","XOXX", "XOXO", "OXOX").map(_.toCharArray)

def solve(board: Array[Array[Char]]): Unit = {
  val h = board.length
  if(h==0)return
  val w = board(0).length


  val visited = Array.fill(h)(Array.fill(w)(false))

  def traverse(i:Int, j:Int): Unit = {
    if(board(i)(j)=='O' && !visited(i)(j)){
      visited(i)(j) = true

      for(
        (x,y)<-List((i-1,j),(i+1,j),(i,j-1),(i,j+1))
        if x>0 && x<h-1 && y>0 && y<w-1
      ) traverse(x,y)
    }
  }

  for(i <- List(0,h-1); j <- 0 until w) traverse(i,j)
  for(j <- List(0,w-1); i <- 1 until h-1) traverse(i,j)
  for(j <- 1 until w-1; i <- 1 until h-1 if !visited(i)(j)) board(i)(j) = 'X'
}

solve(board)

println(board.map(_.mkString).mkString)