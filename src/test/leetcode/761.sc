// Special Binary String
// 1 = 0
// prefix 1 >= 0

def makeLargestSpecial(S: String): String = {

  var ls: List[(Int,Int)] = Nil

  var ind = -1
  var ones = 0
  val l = S.length
  for(i<- 0 until l){
    val c = S(i)
    if(c=='1'){
      ones += 1
    } else {
      if(ones>0) ls = (ones,ind + 1) :: ls
      ones = 0
      ind = i
    }
  }

  ls = ls.reverse
  val toSwap = ls.drop(1).maxBy(_._1)
  println(toSwap)

  // find first on the right
  var i = toSwap._2 + toSwap._1
  var rightones = toSwap._1
  while(rightones != 0 && i<l){
    if(S(i)=='0') rightones-=1
    else rightones += 1
    i+=1
  }
  // swap (toSwap._2 until i-1)
  println(i)

  ""
}

makeLargestSpecial("1101100")