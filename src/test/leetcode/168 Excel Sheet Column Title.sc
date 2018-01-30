def convertToTitle(n: Int): String = {
  var res = ""
  var i = n - 1
  while(i > -1){
    res += ('A' + i % 26).toChar
    i =  i / 26 - 1
  }
  res.reverse
}

convertToTitle(1)
convertToTitle(2)
convertToTitle(25)
convertToTitle(26)

convertToTitle(27)
convertToTitle(28)