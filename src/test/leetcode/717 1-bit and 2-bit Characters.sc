def isOneBitCharacter(bits: Array[Int]): Boolean = {
  val l = bits.length
  var i = l - 1
  if(bits(i)!=0) return false
  i -= 1
  while(i>=0 && bits(i)==1) i-=1

  val numOfOnes = l-2-i
  numOfOnes % 2 != 1
}

isOneBitCharacter(Array(1,0,0))
isOneBitCharacter(Array(1,1,1,0))