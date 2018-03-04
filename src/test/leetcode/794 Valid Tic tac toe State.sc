def validTicTacToe(board: Array[String]): Boolean = {


  val chars = board.flatten
  val cx = chars.count(_=='X')
  val co = chars.count(_=='O')
  if(math.abs(cx - co)>1) return false


  val bd = board.map(_.toCharArray)

  if(cx==0 && co==0) return true
  if(co>cx) return false

  def checkWin(x:Array[Array[Char]]): Boolean ={
    (0 to 2).exists{ i =>
      (x(i)(0) == x(i)(1) && x(i)(0)!=' ' && x(i)(1) == x(i)(2)) ||
        (x(0)(i) == x(1)(i) && x(0)(i)!=' ' && x(1)(i) == x(2)(i))
    } ||
      (x(0)(0) == x(1)(1) && x(1)(1)!=' ' && x(2)(2) == x(1)(1)) ||
      (x(0)(2) == x(1)(1) && x(1)(1)!=' ' && x(2)(0) == x(1)(1))
  }

  if(cx>co){
    for(i<-0 to 2; j<-0 to 2 if bd(i)(j)=='X'){
      var cp = board.map(_.toCharArray)
      cp(i)(j) = ' '
      if(!checkWin(cp)) return true
    }
    return false
  } else {
    for(i<-0 to 2; j<-0 to 2 if bd(i)(j)=='O'){
      var cp = board.map(_.toCharArray)
      cp(i)(j) = ' '
      if(!checkWin(cp)) return true
    }
    return false
  }
}

validTicTacToe(Array("O  ", "   ", "   "))
validTicTacToe(Array("XOX", " X ", "   "))
validTicTacToe(Array("XXX", "   ", "OOO"))
validTicTacToe(Array("XOX", "O O", "XOX"))
validTicTacToe(Array("X  ", "X  ", "O O"))

/*
The first player always places "X" characters,

xxx
xoo
oo
 */