// find if word exists in the grid from any order, horizon or vertical neighbored
def exist(board: Array[Array[Char]], word: String): Boolean = {
  val h = board.length
  if(h==0) return false
  val w = board(0).length

  def search(x:Int, y:Int, next: String, history:List[(Int,Int)]): Boolean = {
    if(next.isEmpty) true
    else if(x>=0 && x<h && y>=0 && y<w && board(x)(y) == next.head && !history.contains((x,y))){
      search(x+1,y,next.tail, (x,y)::history) ||
      search(x-1,y,next.tail, (x,y)::history) ||
      search(x,y+1,next.tail, (x,y)::history) ||
      search(x,y-1,next.tail, (x,y)::history)
    }
    else false
  }

  for(i<-0 until h; j<- 0 until w)
    if(search(i,j,word,Nil)) return true

  false
}

val board = Array("ABCE","SFCS", "ADEE").map(_.toCharArray)
exist(board, "ABCCED")